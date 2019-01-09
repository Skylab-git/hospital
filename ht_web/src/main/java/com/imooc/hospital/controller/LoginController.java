package com.imooc.hospital.controller;

import com.imooc.hospital.entity.User;
import com.imooc.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller("loginController")
public class LoginController {
    @Autowired
    private UserService userService;

    //  /login/loginPrompt.do
    public void loginPrompt(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session=req.getSession();
        session.setAttribute("USER",username);


        List<User> userList = userService.getAllUser();
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                req.getRequestDispatcher("/department/list.do?categoryId=1").forward(req,resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
            }
        }
    }
}
