package com.wangyy.ltd.eurekafeignclient.fallback;

import com.wangyy.ltd.eurekafeignclient.pojo.User;
import com.wangyy.ltd.eurekafeignclient.web.inter.FeignOrderInte;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 需要拿到具体的错误信息
 */
@Component
public class FeignOrderFallBackFactory implements FallbackFactory<FeignOrderInte> {
    @Override
    public FeignOrderInte create(Throwable throwable) {
        return new FeignOrderInte() {
            @Override
            public User getUser(User user) {
                user.setName(throwable.getMessage());
                user.setInfo("降级工厂方法");
                return user;
            }

            @Override
            public User postUser(User user) {
                user.setName(throwable.getMessage());
                return user;
            }
        };
    }
}
