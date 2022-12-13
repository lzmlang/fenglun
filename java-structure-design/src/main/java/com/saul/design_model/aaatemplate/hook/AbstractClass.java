package com.saul.design_model.aaatemplate.hook;

/**
 * @author 枫伦
 * @DESCRIPTION 抽象类，定义模板方法和基本方法
 * @create 2021/5/26 10:11 上午
 */
public abstract class AbstractClass {

    /**
     * 具体方法,声明并实现，继承此抽象类不需实现此方法
     */
    public void concreteMethod() {
        System.out.println("这是一个具体方法");
    }

    /**
     * 抽象方法，abstract关键字标识，只声明，并不实现，继承此抽象类必须实现此方法
     */
    protected abstract void abstractMethod();

    /**
     * 钩子方法，声明并实现（空实现或者定义相关内容皆可），继承此抽象类的子类可扩展实现或者不实现
     */
    public void hookMethod() {
        //这是一个钩子方法可定义一个默认操作或者为空.子类可以在重写这个钩子方法的时候 调用父类的钩子方法.然后在进行扩展
        System.out.println("这是一个钩子方法可定义一个默认操作或者为空.子类可以在重写这个钩子方法的时候调用父类的钩子方法.然后在进行扩展---执行默认操作");
    }

    /**
     * 模板方法，整个算法的骨架
     */
    public void templateMethod() {
        concreteMethod();
        abstractMethod();
        hookMethod();
    }
}
