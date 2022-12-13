package com.saul.design_model.aaachainofresponsibility;

/**
 *职责链模式 (Chain of Responsibility): 使多个对象都有机会处理请求， 从而避免请求的发送者
 * 和接收者之间的耦合关系。 将这个对象连成一条链， 并沿着这条链传递该请求， 直到有一个对
 * 象处理它为止。[DP]
  * 功能描述:
  * @Author luozemin
  * @Date 15:39 2020/11/11
 * @description 责任链模式Test
 * @date 2020/11/1 14:49
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");

        h1.setHandler(h2);
        h2.setHandler(h3);
        h1.operator();
    }
}
