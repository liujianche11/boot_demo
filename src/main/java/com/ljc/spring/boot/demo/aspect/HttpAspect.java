package com.ljc.spring.boot.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    @Pointcut("execution(public * com.ljc.spring.boot.demo.controller.* .*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attr.getRequest();
        System.out.println(request.getRequestURL());
        System.out.println(request.getMethod());
        System.out.println(joinpoint.getSignature().getDeclaringTypeName());
        System.out.println(joinpoint.getSignature().getName());
        System.out.println(joinpoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        System.out.println("------------------------222--------------------");
    }

    @AfterReturning(returning = "obj",pointcut = "log()")
    public void doAfterReturning(Object obj){
        System.out.println(obj);
    }
}
