package com.imooc.hospital.service;

import com.imooc.hospital.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);

    void remove(Integer id);

    void edit(Department department);

    Department getById(Integer id);

    List<Department> getByCategoryId(Integer categoryId);
}
