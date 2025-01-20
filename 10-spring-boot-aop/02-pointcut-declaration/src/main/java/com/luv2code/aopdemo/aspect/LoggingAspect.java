package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    // questo è dove aggiungiamo tutto ciò che è relativo al nostro logging

    // @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    // private void forDaoPackage(){ }

    @Before("allButGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("===>>> Executing @Before advice");
    }

    @Before("allButGetterSetter()")
    public void performApiAnalitics() {
        System.out.println("===>>> Performing API analytics");
    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){}

    // create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){}
    
    // create pointcut: include package ... exclude getter/setter
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..)) && !(getter() || setter()))")
    private void allButGetterSetter(){}


}
