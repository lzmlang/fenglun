package com.saul.design_model.aaaabstractfactory;


/**邮件发送
 * @author 罗泽民
 * @description
 * @date 2020/11/2 20:25
 */
public class MailSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");

    }
}
