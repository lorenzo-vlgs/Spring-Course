package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    // questo è dove aggiungiamo tutto ciò che è relativo al nostro logging

    // iniziamo con @Before advice
    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("===>>> Executing @Before advice");
    }

    @Before("execution(public void add*())")
    public void beforeAnyAdd(){
        System.out.println("===>>> Executing @Before any add method");
    }

    @Before("execution(boolean add*())")
    public void beforeSpecificReturn(){
        System.out.println("===>>> Executing @Before any boolean add");
    }

    // @Before("execution(* *(com.luv2code.aopdemo.entities.Account))")
    @Before("execution(* add*(..))")
    public void beforeSpecificParameter(){
        System.out.println("===>>> Executing @Before any method with any as param");
    }
}
