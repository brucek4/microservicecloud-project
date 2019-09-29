package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zlt"})
@ComponentScan("com.zlt")
public class DeptCustumerFeign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptCustumerFeign_App.class,args);
    }
}
