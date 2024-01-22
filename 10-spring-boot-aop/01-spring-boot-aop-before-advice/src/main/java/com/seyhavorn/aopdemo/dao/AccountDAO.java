package com.seyhavorn.aopdemo.dao;

import com.seyhavorn.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();
}
