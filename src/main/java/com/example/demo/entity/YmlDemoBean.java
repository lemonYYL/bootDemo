package com.example.demo.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * yml配置文件测试
 * @author yali yang
 */
@PropertySource(value = {"classpath:demo.properties"})
@Component
@ConfigurationProperties(prefix = "demo")
@Validated
public class YmlDemoBean {
   // @Value("${demo.name}")
    private String name;
    private String key;
    private Integer age;
    private List<String> friends;
    private Map<String,Integer> map;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ymlDemoBean{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", age=" + age +
                ", friends=" + friends +
                ", map=" + map +
                ", user=" + user +
                '}';
    }
}
