package com.wangyy.ltd.eurekaorderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaOrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderServerApplication.class, args);
    }

}
