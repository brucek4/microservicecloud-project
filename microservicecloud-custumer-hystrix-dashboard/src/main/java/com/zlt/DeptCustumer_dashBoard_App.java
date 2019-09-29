package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptCustumer_dashBoard_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptCustumer_dashBoard_App.class,args);
    }
}
