package com.zlt.controller;

import com.zlt.bean.Dept;
import com.zlt.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController_Custumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/custumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/custumer/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/custumer/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }

}
