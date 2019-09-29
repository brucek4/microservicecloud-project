package com.zlt.controller;

import com.zlt.bean.Dept;
import com.zlt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        return dept;
    }

//    public Dept processHystrix_Get(@PathVariable("id") Long id) {
//        return new Dept().setDeptno(id)
//                .setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
//                .setDb_source("no this database in MySQL");
//    }


    @RequestMapping(value = "dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("***********" + list);

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");

        for (ServiceInstance element : serviceInstanceList) {

            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri()
            );
        }

        return this.discoveryClient;
    }
}
