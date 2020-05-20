package com.wangyy.ltd.eurekafeignclient.fallback;

import com.wangyy.ltd.eurekafeignclient.pojo.User;
import com.wangyy.ltd.eurekafeignclient.web.inter.FeignOrderInte;
import org.springframework.stereotype.Component;

/**
 * 降级方法
 */
@Component
public class FeignOrderFallBack implements FeignOrderInte {
    @Override
    public User getUser(User user) {
        User u = new User();
        u.setInfo("get -> 降级方法测试");
        return u;
    }

    @Override
    public User postUser(User user) {
        User u = new User();
        u.setInfo("post -> 降级方法测试");
        return u;
    }
}
