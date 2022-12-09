package com.saul.design_model.aaabuilder;

/**
 * @author 罗泽民
 * @description 建造者模式test
 * @date 2020/11/1 14:36
 */
public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
        System.out.println(builder.getObjectlist().size());
    }
}
