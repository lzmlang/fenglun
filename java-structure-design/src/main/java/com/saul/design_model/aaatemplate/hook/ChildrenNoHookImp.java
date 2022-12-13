package com.saul.design_model.aaatemplate.hook;

/**
 * @author 枫伦
 * @DESCRIPTION 子类
 * @create 2021/5/26 10:14 上午
 */
public class ChildrenNoHookImp extends AbstractClass {
    @Override
    protected void abstractMethod() {
        System.out.println("子类实现父类的抽象方法");
    }

}
