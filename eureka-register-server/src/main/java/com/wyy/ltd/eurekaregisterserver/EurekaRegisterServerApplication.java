package com.wyy.ltd.eurekaregisterserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaRegisterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterServerApplication.class, args);
    }

}
