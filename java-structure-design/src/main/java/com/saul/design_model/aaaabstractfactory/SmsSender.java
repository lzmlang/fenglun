package com.saul.design_model.aaaabstractfactory;


/** 短信发送实现
 * @author 罗泽民
 * @description
 * @date 2020/11/2 20:25
 */
public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");

    }
}
