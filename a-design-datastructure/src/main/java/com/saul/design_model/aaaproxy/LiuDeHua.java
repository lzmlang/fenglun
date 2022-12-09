package com.saul.design_model.aaaproxy;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/4 21:38
 */
public class LiuDeHua implements Star {
    @Override
    public String sing(String name) {
        System.out.println("给我一杯忘情水");

        return "唱完";
    }

    @Override
    public String dance(String name) {
        System.out.println("开心的马骝");

        return "跳完";
    }
}
