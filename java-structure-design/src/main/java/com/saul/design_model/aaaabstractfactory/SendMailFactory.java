package com.saul.design_model.aaaabstractfactory;

/**
 * @author 罗泽民
 * @description 发邮件工厂
 * @date 2020/11/2 20:29
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
