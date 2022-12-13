package com.saul.design_model.aaaobserver;

/**
 * @author 罗泽民
 * @description 观察者模式test
 * @date 2020/11/1 14:36
 */
public class ObserverTest {
    public static void main(String[] args) {

        ConcreateSubject subject = new ConcreateSubject();
        subject.add(new ConcreateObserver(subject, "x"));
        subject.setSubjectStatus("状态x");
        subject.send();

        subject.add(new ConcreateObserver(subject, "y"));
        subject.setSubjectStatus("状态y");
        subject.send();

        subject.add(new ConcreateObserver(subject, "z"));
        subject.setSubjectStatus("abc");
        subject.send();
        method(1,2);
        method(1+1,2+2);

    }

    public static void method(final Integer a,final Integer b){
        System.out.println(a+b);
    }
}
