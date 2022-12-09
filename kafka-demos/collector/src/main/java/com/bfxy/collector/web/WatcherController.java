package com.bfxy.collector.web;

import com.alibaba.fastjson.JSON;
import com.bfxy.collector.entity.AccurateWatcherMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatcherController {

    @RequestMapping(value = "/accurateWatch")
    public String watch(@RequestBody AccurateWatcherMessage accurateWatcherMessage) {
        String ret = JSON.toJSONString(accurateWatcherMessage);
        System.err.println("----告警内容----:" + ret);
        return "is watched" + ret;
    }

    @RequestMapping(value = "/forward.do")
    public String auth(String code, String state, Model model) throws Exception {
        System.out.println(code + "____" + state);
        return "success";
    }
}
