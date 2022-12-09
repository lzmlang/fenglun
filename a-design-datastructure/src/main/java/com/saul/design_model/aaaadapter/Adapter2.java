package com.saul.design_model.aaaadapter;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/11 11:21
 */
public class Adapter2 implements Targetable {
    private Source source;

    public Adapter2(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
