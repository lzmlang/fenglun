package com.saul.design_model.aaaproxy;

/**
 * @author 罗泽民
 * @description 代理模式test
 * @date 2020/11/1 14:36
 */
public class ProxyTest {
    public static void main(String[] args) {
        int times = 1000000;

        Star ldh = new LiuDeHua();
        JdkProxy proxy = new JdkProxy();
        proxy.setTarget(ldh);

        long time1 = System.currentTimeMillis();
        Star star = (Star) proxy.CreatProxyedObj();
        long time2 = System.currentTimeMillis();
        System.out.println("jdk创建时间：" + (time2 - time1));

        CglibProxy proxy2 = new CglibProxy();
        long time5 = System.currentTimeMillis();
        Star star2 = (Star) proxy2.CreatProxyedObj(LiuDeHua.class);
        long time6 = System.currentTimeMillis();
        System.out.println("cglib创建时间：" + (time6 - time5));

        long time3 = System.currentTimeMillis();
        for (int i = 1; i <= times; i++) {
            star.sing("ss");

            star.dance("ss");
        }
        long time4 = System.currentTimeMillis();
        System.out.println("jdk执行时间" + (time4 - time3));

        long time7 = System.currentTimeMillis();
        for (int i = 1; i <= times; i++) {
            star2.sing("ss");

            star2.dance("ss");
        }

        long time8 = System.currentTimeMillis();

        System.out.println("cglib执行时间" + (time8 - time7));
    }
}
