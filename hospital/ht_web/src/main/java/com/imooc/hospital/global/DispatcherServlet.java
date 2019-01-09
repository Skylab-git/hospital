package com.imooc.hospital.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DispatcherServlet extends GenericServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        //配置Spring容器管理的Bean的详细配置信息
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /**
         *     beanName+方法名
         *    /department/add.do    /login.do
         *    departmentController
         */
        String path = request.getServletPath().substring(1);
        String beanName = null;
        String mothodName = null;

        int index = path.indexOf('/');
        if (index != -1) {
            beanName = path.substring(0, index) + "Controller";
            mothodName = path.substring(index + 1, path.indexOf(".do"));
        } else {
            beanName = "loginController";
            mothodName = path.substring(0, path.indexOf(".do"));
        }
        Object obj = context.getBean(beanName);

        try {
            Method method = obj.getClass().getMethod(mothodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(obj, request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
