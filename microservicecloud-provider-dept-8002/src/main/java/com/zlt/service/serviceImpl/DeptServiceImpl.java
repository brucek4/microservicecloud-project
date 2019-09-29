package com.zlt.service.serviceImpl;

import com.zlt.bean.Dept;
import com.zlt.dao.DeptDao;
import com.zlt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "dept02")
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Cacheable
    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Cacheable
    @Override
    public List<Dept> list() {
        return dao.findAll();
    }

}
