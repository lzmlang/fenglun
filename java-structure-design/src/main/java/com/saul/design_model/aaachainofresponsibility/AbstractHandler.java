package com.saul.design_model.aaachainofresponsibility;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/1 16:12
 */
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
