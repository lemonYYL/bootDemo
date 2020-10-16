package com.example.demo.ctrl;

import com.example.demo.rmqDemo2.RmqPublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @RequestMapping(value = "publish")
    public String publishMsg(){
        rmqPublishService.publish();
        return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@PathVariable("name") String name,@PathVariable("password") String password) {
        if (name.equals("lll") || "123456".equals(password)){
            return "success";
        }else {
            return "login";
        }
    }


    @RequestMapping("/")
    public void index(HttpServletResponse response) {
        try {
            response.sendRedirect("login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
