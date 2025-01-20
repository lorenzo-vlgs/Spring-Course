package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entities.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    // questo è dove aggiungiamo tutto ciò che è relativo al nostro logging
    @AfterReturning(
        pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    public void afterReturningAccounts(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on 
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n===>>> result is: " + result);

        // let's post-process the data ... let's modify it :-)
        
        // convert the account names to uppercase 
        convertToUpper(result);
        System.out.println("\n===>>> result is: " + result);

    }

    private void convertToUpper(List<Account> accounts){
        
        for (Account account : accounts) {
            String upper = account.getName().toUpperCase();
            account.setName(upper);

        }
    }
    @Before("com.luv2code.aopdemo.aspect.UtilityPointCut.allButGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("===>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        //display method arguments
        
        // get args
        Object[] args = joinPoint.getArgs();

        // loop thru args
        for (Object temp : args){
            System.out.println(temp);

            if (temp instanceof Account) {
                Account account = (Account) temp;
                System.out.println("Oggetto Account: " + account.getName() + " " + account.getLevel());
            }
        }
    }
    
}
