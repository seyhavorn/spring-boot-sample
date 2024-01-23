package com.seyhavorn.aopdemo;

import com.seyhavorn.aopdemo.dao.AccountDAO;
import com.seyhavorn.aopdemo.dao.MembershipDAO;
import com.seyhavorn.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService theTrafficFortuneService) {
        return runner -> {
            //demoTheBeforeAdvice(accountDAO, membershipDAO);
            //demoTheAfterReturningAdvice(accountDAO);
            //demoTheAfterThrowingAdvice(accountDAO);
            //demoTheAfterAdvice(accountDAO);
            //demoTheAroundAdvice(theTrafficFortuneService);
            demoTheAroundAdviceHandleException(theTrafficFortuneService);
        };
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

        System.out.println("Calling getFortune");

        boolean tripWire = true;

        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy Fortune is: " + data);

        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program: DemoTheAroundAdvice");
        System.out.println("Calling getFortune");
        String data = theTrafficFortuneService.getFortune();
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        //call method to find the accounts
        List<Account> theAccounts = null;

        try {
            //add a boolean flag to simulate exception:
            boolean tripWire = false;
            theAccounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program: .... Caught exception: " + exc);
        }

        //display the accounts:
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("-------");
        System.out.println(theAccounts);
        System.out.println("\n\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        //call method to find the accounts
        List<Account> theAccounts = null;

        try {
            //add a boolean flag to simulate exception:
            boolean tripWire = true;
            theAccounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program: .... Caught exception: " + exc);
        }

        //display the accounts:
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("-------");
        System.out.println(theAccounts);
        System.out.println("\n\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        //call method to find the accounts
        List<Account> theAccounts = accountDAO.findAccounts();

        //display the accounts:
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("-------");
        System.out.println(theAccounts);
        System.out.println("\n\n");
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        // call the business method:
        Account myAccount = new Account();
        myAccount.setName("Seyha");
        myAccount.setLevel("Platinum");

        accountDAO.addAccount(myAccount, true);
        accountDAO.doWork();

        // call the account dao getter and setter methods:
        accountDAO.setName("seyhaVorn");
        accountDAO.setServiceCode("KH23");

        accountDAO.getName();
        accountDAO.getServiceCode();

        //call membership business method:
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }
}
