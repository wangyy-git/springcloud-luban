package com.wangyy.ltd.eurekafeignclient.fallback;

import com.wangyy.ltd.eurekafeignclient.pojo.User;
import com.wangyy.ltd.eurekafeignclient.web.inter.FeignServiceInte;

public class FeignServiceImpl implements FeignServiceInte {
    @Override
    public User getUser(User user) {
        User u = new User();
        u.setInfo("post -> 降级方法测试");
        return u;
    }

    @Override
    public User postUser(User user) {
        User u = new User();
        u.setName(user.getName());
        u.setInfo("post -> 降级方法测试");
        return u;
    }
}
