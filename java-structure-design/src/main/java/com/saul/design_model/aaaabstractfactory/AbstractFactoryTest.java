package com.saul.design_model.aaaabstractfactory;

/**
 * @author 罗泽民
 * @description 抽象工程模式test
 * @date 2020/11/1 14:36
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
