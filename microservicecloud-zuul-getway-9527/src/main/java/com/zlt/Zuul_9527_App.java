package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_App {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_App.class,args);
    }
}
//140.82.113.4    199.232.5.194