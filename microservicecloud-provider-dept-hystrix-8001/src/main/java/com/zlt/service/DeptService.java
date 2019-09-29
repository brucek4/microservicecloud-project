package com.zlt.service;

import com.zlt.bean.Dept;

import java.util.List;

public interface DeptService {
     boolean add(Dept dept);
     Dept get(Long id);
     List<Dept> list();
}