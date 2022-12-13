package com.saul.design_model.aaaproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/4 21:41
 */
public class CglibProxy implements MethodInterceptor {
    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public Object CreatProxyedObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        // 这里增强
        System.out.println("收钱");

        return arg3.invokeSuper(arg0, arg2);
    }
}