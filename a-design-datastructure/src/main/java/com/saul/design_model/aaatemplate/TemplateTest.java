package com.saul.design_model.aaatemplate;

/** 关于模板方法
 * 对于某一种对象的某一些不是通用的方法,需要抽象成接口让子类去实现以达到不同的效果
 * 像车子.可能大小是发动机是一样的,但是颜色不一样.这个时候就需要把颜色抽取成接口,不同的厂家去实现
 * @author 罗泽民
 * @description 模板方法模式test
 * @date 2020/11/1 14:36
 */
public class TemplateTest {
    public static void main(String[] args) {
        AbstractCalculator whiteCarFactory = new WhiteCarFactory();
        AbstractCalculator blackCarFactory = new BlackCarFactory();
        // 生产白色汽车
        whiteCarFactory.builderCar();
        // 生产黑色汽车
        blackCarFactory.builderCar();
    }
}
