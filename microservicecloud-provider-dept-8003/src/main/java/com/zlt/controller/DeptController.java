package com.zlt.controller;

import com.zlt.bean.Dept;
import com.zlt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept/")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("***********" + list);

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");

        for (ServiceInstance element: serviceInstanceList) {

            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
            + element.getUri()
            );
        }

        return this.discoveryClient;
    }
}
