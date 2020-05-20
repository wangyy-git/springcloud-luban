package com.wangyy.ltd.eurekafeignclient.web;

import com.wangyy.ltd.eurekafeignclient.pojo.User;
import com.wangyy.ltd.eurekafeignclient.result.WyyResult;
import com.wangyy.ltd.eurekafeignclient.web.inter.FeignOrderInte;
import com.wangyy.ltd.eurekafeignclient.web.inter.FeignServiceInte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/feign")
public class FeignController extends BaseController {

    private final FeignOrderInte order;
    private final FeignServiceInte service;

    /**
     * FeignOrderInte 此处注入不止一个值
     */
    @Autowired
    public FeignController(FeignOrderInte order, FeignServiceInte service) {
        this.order = order;
        this.service = service;
    }

    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public WyyResult getOrderUser(@RequestBody User user){

        System.out.println("getOrderUser,param -> " + user);
        user.setInfo("use by feign");
        return super.ok(order.getUser(user));
    }

    @RequestMapping(value = "/postOrder",method = RequestMethod.POST)
    public WyyResult postOrderUser(@RequestBody User user){

        System.out.println("postOrderUser,param ->" + user);
        user.setInfo("use by feign");
        //int i = 1/0;
        return super.ok(order.postUser(user));
    }

    @RequestMapping(value = "/getService",method = RequestMethod.GET)
    public WyyResult getServiceUser(@RequestBody User user){

        System.out.println("getServiceUser,param -> " + user);
        user.setInfo("use by feign");
        return ok(service.getUser(user));
    }

    @RequestMapping(value = "/postService",method = RequestMethod.POST)
    public WyyResult postServiceUser(@RequestBody User user){

        System.out.println("postServiceUser,param -> " + user);

        user.setInfo("use by feign");
        return ok(service.postUser(user));
    }
}
