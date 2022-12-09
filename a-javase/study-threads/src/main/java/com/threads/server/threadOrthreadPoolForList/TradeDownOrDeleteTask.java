package com.threads.server.threadOrthreadPoolForList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.SneakyThrows;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单指定下载或者指定删除task
 *
 * @author 枫伦
 * @DESCRIPTION
 * @create 2022/4/14 4:43 下午
 */
public class TradeDownOrDeleteTask implements Runnable {
    private static String request_url = "erp.superboss.cc";

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
//    private static String request_url_erpa = "erpa.superboss.cc";
//    private static String request_url_gray3 = "puberp.superboss.cc";

    public void single() throws IOException, InterruptedException {
        if (null == listIds || listIds.size() == 0) {
            return;
        }
        List<String> stringList = new ArrayList<>();
        for (String tid : listIds) {
            tid = tid.trim();//去除前后空格
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
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
            if (response_str.contains("好食期退款状态匹配失败")) {
                stringList.add(tid);
            }
            System.out.println(Thread.currentThread().getName() + "---" + tid + "userId" + userId + "---" + response_str);
            response.body().close();
            Thread.sleep(300);
        }
        System.out.println("退款匹配失败的tid有:" + JSONArray.toJSONString(stringList));
    }


    private static void tradeBackendDelete(String sid) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://grayerp.superboss.cc/trade/backend/delete?sid=" + sid)
                .method("POST", body)
                .addHeader("Cookie", STR_COOKIE)
                .addHeader("trackid", "trackid1616661963604_48943")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(sid + "---" + JSON.toJSONString(response.body().string()));
        response.body().close();
    }

    private static String STR_COOKIE = "_ati=6962450304899; _nano_fp=XpEanpX8X0XyX0XblT_RAKTsq2TfM~R~05LECTx_; _tj_validating_staff=383511754910208; lastLoginTime_383511754910208=1649157157000; _tj_censeid=33eb4b66f5b60ea5f236459ffb4858811d04a462; _tj_cookie=383511754910208; visitorId=478828291039744; PHONE_CHECK_SUCCESS_484311377910272=fa073937-80e7-4da9-9a4a-f9b8f2dccae4; superuseragent1=4003a5039f0e8f7a5ba7cc0603669c089e9e77724e6c62093d768ecdbefa044b6f28f1cb9f111da020fe442e802bb9dd7db2083301dcb8d1ee8dcd062c830a8cb8bcb576a87cde656d1383b848ef44b2fc34deee3cbaaec01d485273dce66c3af86e770a04250ad5d44ef33d51476fd585bcd8acca072660527823276f35b526; auth=4e45a0d8ab204536066955f8bb709cc99f9f667f_464547625249280; JSESSIONID=5D256B21A954FA6A011D1329B45D8067; super_memSessionId1=c8f911d5d8af2be0075257f0a35ae60335e5ad291bc221ec158b014bcfb963e844d4a9b592fa8c09164ccb73c4a0828c79fdd7080e804fffbb6bab787d419995; ray-authentication=ed0e85df25d9418b8813bc04aac2a214_183.134.110.211; _new_tj_censeid=9021f7ca2b6f1722d25b015e741f68f7f485723c; _tj_intercept_login_erp=205e591a-a722-4bfd-99b1-958182ccc036; _censeid=62134c052313734c96835e683029c97518d19991; _shatg=10afe7e1-6fdf-4199-a42f-d0cf427558f9; _pdd_page_code=b3f9d75cb0b14778d04e3058eb9a4e47f89d96e38f4e; _pati=e9Uckw4VtNvJplWVnq6CWEE6yxYUw8yi; _pati_v=v2; 3AB9D23F7A4B3C9B=TWWAOIKE6T6Q5JMUKUM7A3X6XANQYEOFNT5TSZZ6T4HUMHTZ6LU5HMAEOH7GLUMERVLZS23BPVBN2ARXR5FATOIOK4";

}
