package com.seyhavorn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging

    // let's state with an @Before advice
    //@Before("execution (public void add*())")

    //@Before("execution(* add*(com.seyhavorn.aopdemo.Account))")

    //@Before("execution(* add*(com.seyhavorn.aopdemo.Account, ..))")

    @Before("execution(* com.seyhavorn.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>>> Executing @Before advice on method()");
    }
}
