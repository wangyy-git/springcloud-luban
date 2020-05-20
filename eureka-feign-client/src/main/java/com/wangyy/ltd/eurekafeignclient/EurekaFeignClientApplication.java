package com.wangyy.ltd.eurekafeignclient;

import loadBlance.OrderLoadBlanceConfig;
import loadBlance.ServiceLoadBlanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@RibbonClients({
        @RibbonClient(name = "eureka-service-server",configuration = ServiceLoadBlanceConfig.class),
        @RibbonClient(name = "eureka-order-server",configuration = OrderLoadBlanceConfig.class)
})
@EnableCircuitBreaker
@SpringBootApplication
public class EurekaFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientApplication.class, args);
    }

}
