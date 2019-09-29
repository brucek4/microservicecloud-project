package com.zlt.dao;

import com.zlt.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptDao {

     boolean addDept(Dept dept);
     Dept findById(Long id);
     List<Dept> findAll();

}
