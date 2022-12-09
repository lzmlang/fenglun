package com.saul.design_model.aaaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/4 21:39
 */
public class JdkProxy implements InvocationHandler {
    // 目标类，也就是被代理对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里可以做增强
        System.out.println("收钱");

        Object result = method.invoke(target, args);

        return result;
    }

    // 生成代理类
    public Object CreatProxyedObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


}
