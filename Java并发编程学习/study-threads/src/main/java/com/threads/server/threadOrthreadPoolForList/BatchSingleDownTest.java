package com.threads.server.threadOrthreadPoolForList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.threads.server.utils.ExcelUtils;
import lombok.SneakyThrows;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BatchSingleDownTest {

    static final int THREAD_SIZE = 100;

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("single-thread-%d").build();
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            6,
            20,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),
            build,
            new AbortPolicy());

    public static void main(String[] args) throws FileNotFoundException {
        String userId = "140785";//天猫142449   抖音142382 淘宝 142480
        File file = new File("/Users/saul/Desktop/txy.xlsx");//工作簿1
        InputStream inputStream = new FileInputStream(file);
        List<Object[]> objects = ExcelUtils.importExcel(inputStream, 2);
        assert objects != null;
        List<String> list = new ArrayList<>();

        for (Object[] datas : objects) {
//            if (datas.equals(objects.get(0))) {
//                continue;
//            }
//            System.out.println(datas[0] + "\t" + datas[1] + "\t" + datas[2]);
//            list.add((String) datas[0])
            String tid = datas[1] + "";
            if (StringUtils.isBlank(tid)) {
                continue;
            }
            if (tid.contains(",")) {
                String[] split = tid.split(",");
                list.add(split[0]);
                list.add(split[1]);
                continue;
            }
            list.add(datas[1] + "");
        }
// 推送游戏开始
        long start = System.currentTimeMillis();
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / THREAD_SIZE + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % THREAD_SIZE == 0;
        List<String> cutList = null;
        List<List<String>> dataList = new ArrayList<>();
        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(THREAD_SIZE * i, dataSize);
            } else {
                cutList = list.subList(THREAD_SIZE * i, THREAD_SIZE * (i + 1));
            }
            dataList.add(cutList);
        }

        for (List<String> tids : dataList) {
            TradeDownOrDeleteTask tradeDownOrDeleteTask = new TradeDownOrDeleteTask(userId, tids);
            threadPoolExecutor.submit(tradeDownOrDeleteTask);
        }
        threadPoolExecutor.shutdown();
    }


    public static class TradeDownOrDeleteTask implements Runnable {
        private static String request_url = "erpa.superboss.cc";

        private List<String> listIds;
        private String userId;

        public TradeDownOrDeleteTask(String userId, List<String> listIds) {
            this.listIds = listIds;
            this.userId = userId;
        }

        @SneakyThrows
        @Override
        public void run() {
            single();
        }

        public void single() throws IOException, InterruptedException {
            if (null == listIds || listIds.size() == 0) {
                return;
            }
            List<String> stringList = new ArrayList<>();
            for (String tid : listIds) {
                try {
                    tid = tid.trim();//去除前后空格
                    OkHttpClient client = new OkHttpClient().newBuilder().build();
                    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                    RequestBody body = RequestBody.create(mediaType, "api_name= trade_sync_single&userId=" + userId + "&tid=" + tid);
                    Request request = new Request.Builder()
                            .url("https://" + request_url + "/trade/sync/single")
                            .method("POST", body)
                            .addHeader("Cookie", STR_COOKIE)
                            .addHeader("Content-Type", "application/x-www-form-urlencoded")
                            .build();
                    Response response = client.newCall(request).execute();
                    String response_str = response.body().string();
                    try {
                        JSONObject jsonObject = JSONObject.parseObject(response_str);
                        Integer result = (Integer) jsonObject.get("result");
                        if (!(result == 1)) {
                            stringList.add(tid);
                            System.out.println(tid + "指定下载错误:" + jsonObject.get("message"));
                        }
//                        if (response_str.contains("会话过期") || response_str.contains("会话异常")) {
//                            System.out.println(Thread.currentThread().getName() + "---" + tid + "--userId:" + userId + "---" + response_str);
//                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    response.body().close();
                    Thread.sleep(200);
//                    System.out.println(atomicInteger.incrementAndGet());
                    atomicInteger.incrementAndGet();
                } catch (Exception e) {
                    stringList.add(tid);
                }
            }
            System.out.println("失败的tid有:" + JSONArray.toJSONString(stringList));
            System.out.println(atomicInteger.get());
        }

        private static String STR_COOKIE = "_ati=6962450304899; _tj_validating_staff=383511754910208; lastLoginTime_383511754910208=1649157157000; _tj_censeid=33eb4b66f5b60ea5f236459ffb4858811d04a462; _tj_cookie=383511754910208; PHONE_CHECK_SUCCESS_484311377910272=fa073937-80e7-4da9-9a4a-f9b8f2dccae4; superuseragent1=4003a5039f0e8f7a5ba7cc0603669c089e9e77724e6c62093d768ecdbefa044b6f28f1cb9f111da020fe442e802bb9dd7db2083301dcb8d1ee8dcd062c830a8cb8bcb576a87cde656d1383b848ef44b2fc34deee3cbaaec01d485273dce66c3a4ee75001354cd7c8bcc1374870c201f885bcd8acca072660527823276f35b526; index_daoqi_dlg=true; super_memSessionId1=af88a19109b89a1bca170bcc6532dab543d8103850d60912ea6f7af64bda033e44d4a9b592fa8c09164ccb73c4a0828c1b6105415366e10cbd2c0827890eba6c; auth=cd8b3cafb9d46d479615c7f68f1ddc56d0f32150_464547625249280; ray-authentication=22c96293b38445b1a606d45ced9f65d6_218.76.8.105; _new_tj_censeid=8b80fb24889ab53fd4a50a9821a442cb41ee21c9; _tj_intercept_login_erp=e2c1d6c7-e712-47c5-90d8-41d33efbec91; _censeid=5e2ec5198a6215332c0679eb379b8fa807636469; _shatg=67baf170-edcf-4c5a-94e2-e11ae592a2cb; 3AB9D23F7A4B3C9B=TWWAOIKE6T6Q5JMUKUM7A3X6XANQYEOFNT5TSZZ6T4HUMHTZ6LU5HMAEOH7GLUMERVLZS23BPVBN2ARXR5FATOIOK4";
    }
}
