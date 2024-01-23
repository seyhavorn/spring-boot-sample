package com.seyhavorn.aopdemo.dao;

import com.seyhavorn.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImp implements AccountDAO {
    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        //for academic purposes ...simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();
        //create sample accounts:
        Account tmp1 = new Account("Seyha", "Silver");
        Account tmp2 = new Account("cheat", "Gold");
        Account tmp3 = new Account("Didi", "Platinum");

        //add them to our accounts list:
        myAccounts.add(tmp1);
        myAccounts.add(tmp2);
        myAccounts.add(tmp3);
        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my db work: adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
