package com.seyhavorn.aopdemo.dao;

import com.seyhavorn.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountSDAOImp implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my db work: adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return true;
    }
}
