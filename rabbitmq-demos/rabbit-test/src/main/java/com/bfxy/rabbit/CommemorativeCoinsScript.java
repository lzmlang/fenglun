package com.bfxy.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.*;

import java.io.IOException;

/**
 * @author 罗泽民
 * @description
 * @date 2021/12/14 22:50
 */

//@RestController
public class CommemorativeCoinsScript {
    private static String mobile = "";
    //下面几个数据可以通过这个url获取 https://cmcoins.boc.cn/ocas-web/BaseInfoForOcas/product.json?random=0.021260761876909617
    private static String productId = "DAA202101";
    private static String proNum = "201916";
    private static String productName = "第24届冬季奥林匹克运动会纪念钞（1套2张）";
    private static String briefName = "冬奥钞";
    private static String proVersion = "01";
    private static String maxNum = "10";
    //兑换日期
    private static String cexDate = "20211221";
    //以下三个数据用途未知
    private static String partnerFlag = "";
    private static String terminalId = "";
    private static String channel = "";


    private static String getRequestStr() {
        String requestStr = "{\n" +
                "    \"method\": \"PsnCoinApply\",\n" +
                "    \"params\": {\n" +
                "        \"identyType\": \"01\",\n" +
                "        \"identyNumber\": \"430682199009143111\",\n" +
                "        \"name\": \"沈维民\",\n" +
                "        \"mobile\": " + mobile + ",\n" +
                "        \"productId\":" + productId + ",\n" +
                "        \"proNum\": " + proNum + ",\n" +
                "        \"count\": " + maxNum + ",\n" +
                "        \"validationChar\": " + getVerificationCode() + ",\n" +
                "        \"bankId\": \"12383\",\n" +
                "        \"bankName\": \"中国银行岳阳市巴陵东路支行\",\n" +
                "        \"address\": \"岳阳市岳阳楼区巴陵东路与琵琶王路（市政规划路）之间的“明星央城”营销中心临街铺面\",\n" +
                "        \"bankmobile\": \"0730-8351773\",\n" +
                "        \"productName\": " + productName + ",\n" +
                "        \"orgProvID\": \"00019\",\n" +
                "        \"orgL1branchID\": \"430000\",\n" +
                "        \"orgCityID\": \"430600\",\n" +
                "        \"province\": \"湖南省\",\n" +
                "        \"proVersion\": " + proVersion + ",\n" +
                "        \"briefName\": " + briefName + ",\n" +
                "        \"smsValidCode\": \"\",\n" +
                "        \"cexDate\": " + cexDate + ",\n" +
                "        \"partnerFlag\": \"0000\",\n" +
                "        \"terminalId\": \"15\",\n" +
                "        \"channel\": \"01\"\n" +
                "    },\n" +
                "    \"header\": {\n" +
                "        \"agent\": \"WEB15\",\n" +
                "        \"version\": \"1.0\",\n" +
                "        \"device\": \"\",\n" +
                "        \"platform\": \"Win32\",\n" +
                "        \"plugins\": \"\",\n" +
                "        \"page\": \"\",\n" +
                "        \"local\": \"zh_CN\",\n" +
                "        \"ext\": \"\"\n" +
                "    }\n" +
                "}";
        return requestStr;
    }

    public static void main(String[] args) throws IOException {
//        getVerificationCode();
        submited();
    }

    /**
     * 功能描述: 纪念币预约提交
     *
     * @return void
     * @Author luozemin
     * @Date 23:23 2021/12/14
     * @Param []
     **/
    private static void submited() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, getRequestStr());
        Request request = new Request.Builder()
                .url("https://cdn1.cmcoins.boc.cn/ocas-web/_bfwajax.do?_locale=zh_CN")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
//        System.out.println(JSON.toJSONString(response.body()));
        System.out.println(response.toString());
    }

    /**
     * 功能描述: 获取验证码
     *
     * @return java.lang.String
     * @Author luozemin
     * @Date 23:13 2021/12/14
     * @Param []
     **/
    private static String getVerificationCode() {
        long currentTimeMillis = System.currentTimeMillis();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://cdn1.cmcoins.boc.cn/ocas-web/ImageValidation/validation/" + currentTimeMillis + ".gif ")
                .build();
        try {
            Response response = client.newCall(request).execute();
            ChaoJiYingConstant chaoJiYingConstant = new ChaoJiYingConstant();
            //识别图形验证码
            String verify = ChaoJiYing.PostPic(
                    chaoJiYingConstant.getUsername(),
                    chaoJiYingConstant.getPassword(),
                    chaoJiYingConstant.getSoftid(),
                    chaoJiYingConstant.getCodetype(),
                    chaoJiYingConstant.getLenmin(),
                    response.body().bytes());
            System.out.println("verify: " + verify);
            return verify;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ChaoJiYingConstant {
        private String username = "15700742635";
        private String password = "adminadmin";
        private String softid = "925997";
        private String codetype = "1902";
        private String lenmin = "0";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class CoinsNeedData {
        //預約人姓名
        private String name;
        //身份证号码
        private String identyNumber;
    }
}


