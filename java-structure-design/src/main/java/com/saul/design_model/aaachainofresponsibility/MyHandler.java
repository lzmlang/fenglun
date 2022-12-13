package com.saul.design_model.aaachainofresponsibility;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/1 16:13
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + "------deal!");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
