package com.example.demo.ctrl;

import com.example.demo.rmqDemo2.RmqPublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yali yang
 */
@Controller
public class HelloRestCtrl {
    Logger logger = LoggerFactory.getLogger(HelloRestCtrl.class);

    @Autowired
    private RmqPublishService rmqPublishService;

    @RequestMapping(value = "hello")
    public String hello(){
        logger.debug("debug level......");
        logger.info("hello ctrl.....");
        logger.warn("warn level...");
        logger.error("error level....");
        return "welcome";
    }

    @RequestMapping(value = "successCtrl")
    public String success(Map<String,Object> map){
        map.put("hello","嗨");
        List<String> list = new ArrayList<>();
        list.add("array0");
        list.add("array1");
        list.add("array2");
        map.put("list",list);
        return "success";
    }

    /**
     * 测试代码提交  测试提交   测试提交
     * @return
     */
    @RequestMapping(value = "publish")
    public String publishMsg(){
        rmqPublishService.publish();
        return "success";
    }

    @RequestMapping(value = "testCommit")
    public String testCommit(){
        System.out.println("测试提交");
        return "success";
    }

    @RequestMapping(value = "testCommit1")
    public String testCommit1(){
        System.out.println("测试提交");
        return "success";
    }
    @RequestMapping(value = "testCommit2")
    public String testCommit2(){
        System.out.println("测试提交");
        return "success";
    }
}
