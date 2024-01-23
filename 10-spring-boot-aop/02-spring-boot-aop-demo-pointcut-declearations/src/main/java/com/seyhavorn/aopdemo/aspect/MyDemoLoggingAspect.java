package com.seyhavorn.aopdemo.aspect;

import com.seyhavorn.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution (* com.seyhavorn.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJointPoint) throws Throwable {
        //print out method we are advising on
        String method = theProceedingJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>>>> Executing @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method
        Object result = null;

        try {
            theProceedingJointPoint.proceed();
        } catch (Exception exc) {
            //log the exception:
            System.out.println(exc.getMessage());

            //give user a custom message:
            result = "Major accident! But no worries, you private AOP helicopter is on the way!";
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration:
        long duration = end - begin;
        System.out.println("\n=====>>>> Duration: " + duration / 1000.0 + "seconds");

        return result;
    }

    @After("execution (* com.seyhavorn.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint) {
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution (* com.seyhavorn.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint, Throwable theExc) {
        //print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>>>> Executing @AfterThrowing on method: " + method);

        // log the exception:
        System.out.println("\n\n======>>>> The exception is: " + theExc);
    }

    //add a new advice for @AfterReturning on the findAccount method

    @AfterReturning(pointcut = "execution (* com.seyhavorn.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJointPoint, List<Account> result) {
        //print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>>>> Executing @AfterReturning on method: " + method);

        //print out the results of the method call
        System.out.println("\n======>>>> Result is : " + result);

        //let's post-process the data... let;s modify it :-)

        //convert the account name to uppercase:
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for (Account tmpAccount : result) {
            //get uppercase version of name:
            String theUpperName = tmpAccount.getName().toUpperCase();

            //update the name on the account:
            tmpAccount.setName(theUpperName);
        }
    }

    @Before("com.seyhavorn.aopdemo.aspect.LovAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n======>>>> Executing @Before advice on method()");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments:

        //get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args:
        for (Object tmgArg : args) {
            System.out.println(tmgArg);

            if (tmgArg instanceof Account) {
                // downcast and print Account specific stuff:
                Account theAccount = (Account) tmgArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }

    }

}
