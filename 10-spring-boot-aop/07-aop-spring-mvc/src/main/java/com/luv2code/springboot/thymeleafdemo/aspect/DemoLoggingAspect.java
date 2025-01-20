package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    
    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    //setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    //setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("====>>> in @before: calling method: " + method);
        // display the arguments to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop thru and display args
        for (Object tempArgs : args){
            logger.info("====>>> " + tempArgs);
        }

    }

    @AfterReturning(
        pointcut = "forAppFlow()",
        returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){

    }
}
