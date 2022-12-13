package com.saul.design_model.aaabuilder;

import com.saul.design_model.aaaabstractfactory.MailSender;
import com.saul.design_model.aaaabstractfactory.Sender;
import com.saul.design_model.aaaabstractfactory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗泽民
 * @description
 * @date 2020/11/1 16:34
 */
public class Builder {
    private List<Sender> Objectlist = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            Objectlist.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            Objectlist.add(new SmsSender());
        }
    }

    public List<Sender> getObjectlist() {
        return Objectlist;
    }
}
