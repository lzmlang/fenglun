package com.saul.design_model.aaasingleton;

/**
 * @author 罗泽民
 * @description 单列模式
 * @date 2020/11/2 22:20
 */
public class Singleton {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /* 静态工程方法，创建实例 */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }

    //多线程环境下使用
    public static synchronized Singleton getInstanceThreads() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //多线程环境下使用,同事又能保证性能
    public static Singleton getInstanceThreads2() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
