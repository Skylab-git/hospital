package com.imooc.hospital.controller;

import com.imooc.hospital.entity.Log;
import com.imooc.hospital.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {

    @Autowired
    private LogService logService;

    public void operrationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list=logService.getOperationLog();
        request.setAttribute("LIST",list);
        request.setAttribute("TYPE","操作");
        request.getRequestDispatcher("/WEB-INF/logList.jsp").forward(request,response);
    }


}