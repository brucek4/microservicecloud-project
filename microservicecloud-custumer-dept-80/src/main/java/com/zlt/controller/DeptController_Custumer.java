package com.zlt.controller;

import com.zlt.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/custumer/")
@RestController
public class DeptController_Custumer {

    @Autowired
    private RestTemplate restTemplate;

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT/";

    @RequestMapping("dept/add")
    public boolean add(Dept dept){
        return  restTemplate.postForObject(REST_URL_PREFIX + "dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        return  restTemplate.getForObject(REST_URL_PREFIX + "dept/get/" + id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("dept/list")
    public List<Dept> list(){
        return  restTemplate.getForObject(REST_URL_PREFIX + "dept/list",List.class);
    }

    @RequestMapping(value = "dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX + "dept/discovery/" ,Object.class);
    }


}
