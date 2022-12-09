package com.saul.design_model.aaafactorymethod;

/**
 * @author 罗泽民
 * @description 工厂模式test
 * @date 2020/11/1 14:36
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }
}
