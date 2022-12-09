package com.saul.design_model.aaadecorator;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/11 15:02
 */
public class Decorator implements Sourceable {
    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
