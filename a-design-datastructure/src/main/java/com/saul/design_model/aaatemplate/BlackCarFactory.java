package com.saul.design_model.aaatemplate;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/15 17:16
 */
public class BlackCarFactory extends AbstractCalculator {
    @Override
    void coloring() {
        System.out.println("给汽车喷上黑色的车漆--" + name.equals("luozemin"));
    }
}
