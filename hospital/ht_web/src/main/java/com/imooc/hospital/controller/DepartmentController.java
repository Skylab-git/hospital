package com.imooc.hospital.controller;

import com.imooc.hospital.entity.Department;
import com.imooc.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Integer medicineId = 1;//内科
    private final Integer surgeryId = 2;//外科

    // /department/list.do
    public void list(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("categoryId"));
        List<Department> list = departmentService.getByCategoryId(id);

        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/category.jsp").forward(req, response);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        departmentService.remove(id);
        req.getRequestDispatcher("/department/list.do?categoryId=1").forward(req, resp);
    }
    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req,resp);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Department department = new Department();
        department.setName(name);
        department.setCategoryId(categoryId);
        department.setCreateTime(new Date());
        department.setUpdateTime(new Date());
        departmentService.add(department);
        req.getRequestDispatcher("/department/list.do?categoryId=1").forward(req,resp);
    }
}
