package com.saul.design_model.aaaobserver;

/**
 * @author 罗泽民
 * @description 具体的观察者(具体的消费者)
 * @date 2020/11/11 17:17
 */
public class ConcreateObserver extends Observer {
    private String name;
    private String observerStatus;
    //具体的通知者
    private ConcreateSubject subject;

    public ConcreateObserver(ConcreateSubject subject, String name) {
        this.name = name;
        this.subject = subject;
    }

    public ConcreateSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreateSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        observerStatus = subject.getSubjectStatus();
        System.out.println("观察者" + name + "的新状态是:" + observerStatus);
    }
}
