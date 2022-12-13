package com.saul.design_model.aaasingleton;

/**
 * @author 罗泽民
 * @description 单列模式
 * @date 2020/11/2 22:20
 */
public class Singleton2 {
    /* 私有构造方法，防止被实例化 */
    private Singleton2() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton2 instance = new Singleton2();
    }


    /* 获取实例 */
    public static Singleton2 getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
