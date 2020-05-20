package com.wangyy.ltd.eurekafeignclient.web.inter;

import com.wangyy.ltd.eurekafeignclient.fallback.FeignOrderFallBackFactory;
import com.wangyy.ltd.eurekafeignclient.pojo.User;
import com.wangyy.ltd.eurekafeignclient.fallback.FeignOrderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RequestMapping("/order")
@FeignClient(value = "eureka-order-server",fallbackFactory = FeignOrderFallBackFactory.class)
public interface FeignOrderInte {

    @RequestMapping(value = "/order/get",method = RequestMethod.GET)
    User getUser(@RequestBody User user);

    @RequestMapping(value = "/order/post",method = RequestMethod.POST)
    User postUser(@RequestBody User user);

}
