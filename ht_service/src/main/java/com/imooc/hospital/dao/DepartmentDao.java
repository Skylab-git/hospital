package com.imooc.hospital.dao;

import com.imooc.hospital.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department select(Integer id);
    List<Department> selectByCategoryId(Integer categoryId);
}
