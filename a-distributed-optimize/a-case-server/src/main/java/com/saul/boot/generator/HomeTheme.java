package com.saul.boot.generator;

public class HomeTheme {

    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//        return;
        MysqlGenerator generator = new MysqlGenerator("127.0.0.1", 3306, "erp_omall", "root", "root");
        generator.setParent("com.raycloud.erp.omll.data");
        generator.run("credit", "omall_express", "罗泽民");//包名（ 暂时不用），表名，作者


    }

}
