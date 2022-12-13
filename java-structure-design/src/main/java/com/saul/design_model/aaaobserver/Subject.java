package com.saul.design_model.aaaobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗泽民
 * @description 抽象通知者 (生产者)
 * @date 2020/11/11 17:08
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    /**
     * 功能描述: 增加观察者
     *
     * @return
     * @Author luozemin
     * @Date 17:11 2020/11/11
     * @Param
     **/
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 功能描述: 移除观察者
     *
     * @return
     * @Author luozemin
     * @Date 17:11 2020/11/11
     * @Param
     **/
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 功能描述: 通知
     *
     * @return
     * @Author luozemin
     * @Date 17:12 2020/11/11
     * @Param
     **/
    public void send() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
