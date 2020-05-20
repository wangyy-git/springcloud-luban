package com.wangyy.ltd.eurekaserviceserver.controller;

import com.wangyy.ltd.eurekaserviceserver.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/service")
public class ServiceController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User getUser(@RequestBody User user){
        log.info("{} 被调用",port);

        user.setInfo("service:port --> " + user.getInfo() + " -> " + port);
        return user;
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public User postUser(@RequestBody User user){
        log.info("{} 被调用",port);

        user.setInfo("service:port --> " + user.getInfo() + " -> " + port);
        return user;
    }


}
