package com.lzm.stuty.customstarter;

import org.springframework.stereotype.Service;

/**
 * @author luo_zm
 * @DESCRIPTION
 * @create 2020/8/27 15:51
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello springboot";
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.print(i.equals(j)); //false
    }
}
