package com.wangyy.ltd.eurekafeignclient.web.inter;


import com.wangyy.ltd.eurekafeignclient.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RequestMapping("/service")
@FeignClient("eureka-service-server")
public interface FeignServiceInte {

    @RequestMapping(value = "/service/get")
    User getUser(@RequestBody User user);

    @RequestMapping(value = "/service/post",method = RequestMethod.POST)
    User postUser(@RequestBody User user);
}
