package com.seyhavorn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LovAopExpressions {

    @Pointcut("execution(* com.seyhavorn.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    //create a pointcut for getter methods:
    @Pointcut("execution(* com.seyhavorn.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    //create a pointcut for setter methods:
    @Pointcut("execution(* com.seyhavorn.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    //create pointcut: include package ... exclude getter/setter:
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
