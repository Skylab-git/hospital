package com.imooc.hospital.service.impl;

import com.imooc.hospital.dao.DepartmentDao;
import com.imooc.hospital.entity.Department;
import com.imooc.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department getById(Integer id) {
        Department department=departmentDao.select(id);
        return department;
    }

    public List<Department> getByCategoryId(Integer categoryId) {
        List<Department> list=departmentDao.selectByCategoryId(categoryId);
        return list;
    }
}
