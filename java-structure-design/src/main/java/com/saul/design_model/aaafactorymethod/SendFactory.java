package com.saul.design_model.aaafactorymethod;

/**
 * @author 罗泽民
 * @description 工厂类
 * @date 2020/11/2 20:26
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
