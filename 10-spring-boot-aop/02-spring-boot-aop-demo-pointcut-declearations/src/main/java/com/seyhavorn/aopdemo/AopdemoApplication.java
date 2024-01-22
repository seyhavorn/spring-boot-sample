package com.seyhavorn.aopdemo;

import com.seyhavorn.aopdemo.dao.AccountDAO;
import com.seyhavorn.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(accountDAO, membershipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        // call the business method:
        Account myAccount = new Account();
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
