package com.saul.design_model.aaachainofresponsibility.dahua;

/**
 * @author 罗泽民
 * @description 具体处理类, 处理它所负责的请求, 可访问它的继任者
 * @date 2020/11/11 15:49
 */
public class ConcreateHandler2 extends Handler {
    @Override
    public void handlerRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("ConcreateHandler2 处理请求,request的大小: "+request);
        } else if (super.successor != null) {
            super.successor.handlerRequest(request);
        }
    }
}
