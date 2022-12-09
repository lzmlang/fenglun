package com.saul.design_model.aaaadapter;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/11 11:21
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
