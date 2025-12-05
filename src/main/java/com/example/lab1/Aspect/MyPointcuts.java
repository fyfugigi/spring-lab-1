package com.example.lab1.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcuts {

    @Pointcut("execution(* com.example.lab1.Service.*.get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* com.example.lab1.Service.*.save*(..)) || execution(* com.example.lab1.Service.*.update*(..))")
    public void allModifyMethods(){}

    @Pointcut("within(com.example.lab1.Controller.ProductController)")
    public void controllerMethods(){}
}
