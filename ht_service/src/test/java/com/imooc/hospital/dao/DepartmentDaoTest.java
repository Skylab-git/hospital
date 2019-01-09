package com.imooc.hospital.dao;

import com.imooc.hospital.BaseTest;
import com.imooc.hospital.entity.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentDaoTest extends BaseTest {






    @Autowired
    private DepartmentDao departmentDao;


    @Test
    public void test() {
        Department departmentDaoList=departmentDao.select(1);
    }
}
