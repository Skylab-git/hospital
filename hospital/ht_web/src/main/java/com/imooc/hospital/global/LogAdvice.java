package com.imooc.hospital.global;

import com.imooc.hospital.entity.Log;
import com.imooc.hospital.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;
    //操作日志
    @AfterReturning("execution(* com.imooc.hospital.controller.*.*(..)) && !execution(* com.imooc.hospital.controller.*.to*(..)) && !execution(* com.imooc.hospital.controller.LoginController.*(..))")
//    @After("execution(* com.imooc.hospital.controller.*.*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log=new Log();
        //记录操作的模块  getTarget():获取所在类  getSimpleName()：获取类名
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        //记录操作行为---所调用的方法  getSignature():取出方法的签名
        log.setOperation(joinPoint.getSignature().getName());
        //取出切点的第一个参数---request
        HttpServletRequest request= (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("USER");
        //记录操作人员
        log.setOperator(username);
        log.setResult("成功");

        logService.addOperationLog(log);
    }

}
