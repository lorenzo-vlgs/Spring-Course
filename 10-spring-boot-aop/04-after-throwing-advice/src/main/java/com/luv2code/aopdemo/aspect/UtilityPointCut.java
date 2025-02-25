package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UtilityPointCut {

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){}
    
    // create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){}
    
    // create pointcut: include package ... exclude getter/setter
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..)) && !(getter() || setter()))")
    public void allButGetterSetter(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){ } 

}
