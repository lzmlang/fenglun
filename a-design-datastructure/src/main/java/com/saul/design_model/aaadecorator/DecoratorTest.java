package com.saul.design_model.aaadecorator;

/**
 * @author 罗泽民
 * @description 装饰者模式test
 * @date 2020/11/1 14:36
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Decorator decorator = new Decorator(sourceable);
        decorator.method();
    }

}
