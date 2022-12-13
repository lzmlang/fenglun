package com.saul.design_model.aaadecorator;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/11 15:01
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
