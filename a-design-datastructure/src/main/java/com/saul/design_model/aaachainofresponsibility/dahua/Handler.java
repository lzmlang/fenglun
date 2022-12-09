package com.saul.design_model.aaachainofresponsibility.dahua;

/**
 * 处理请示接口
 *
 * @author 罗泽民
 * @description
 * @date 2020/11/11 15:46
 */
public abstract class Handler {
    protected Handler successor;
    //设置继任者
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    //处理请求的抽象方法
    public abstract void  handlerRequest(int request);
}
