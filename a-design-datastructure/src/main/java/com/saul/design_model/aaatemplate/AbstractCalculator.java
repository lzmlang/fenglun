package com.saul.design_model.aaatemplate;

/**
 * @author 罗泽民
 * @description 模板方法顶级抽象接口
 * @date 2020/11/15 17:15
 */
public abstract class AbstractCalculator {
    protected String name = "lzm";

    void createFrame() {
        System.out.println("制造汽车框架");
    }

    void installComponent() {
        System.out.println("安装零件");
    }

    abstract void coloring();

    void over() {
        System.out.println("汽车制造完毕");
    }

    void builderCar() {
        // 1. 制造汽车框架
        createFrame();
        // 2. 安装汽车零件
        installComponent();
        // 3. 汽车喷漆，上色
        coloring();
        // 4. 汽车制造完毕
        over();
    }
}
