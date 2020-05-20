package com.wangyy.ltd.eurekazuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EurekaZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulServerApplication.class, args);
    }

}
