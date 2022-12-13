package com.saul.design_model.aaachainofresponsibility.dahua;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/11 16:35
 */
public class Test {
    public static void main(String[] args) {
        ConcreateHandler1 concreateHandler1 = new ConcreateHandler1();
        ConcreateHandler2 concreateHandler2 = new ConcreateHandler2();
        ConcreateHandler3 concreateHandler3 = new ConcreateHandler3();
        concreateHandler1.setSuccessor(concreateHandler2);
        concreateHandler2.setSuccessor(concreateHandler3);

        for (int i = 1; i < 30; i++) {
            concreateHandler1.handlerRequest(i);
        }
    }
}
