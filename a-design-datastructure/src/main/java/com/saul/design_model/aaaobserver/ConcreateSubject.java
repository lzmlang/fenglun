package com.saul.design_model.aaaobserver;

/**
 * @author 罗泽民
 * @description 具体的通知者(具体的生产者)
 * @date 2020/11/11 17:14
 */
public class ConcreateSubject extends Subject {
    //具体被观察者的状态
    private String subjectStatus;

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }
}
