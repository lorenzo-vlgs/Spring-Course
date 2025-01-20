package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.entities.Account;

public interface IAccount {
    
    void addAccount(Account account, boolean vipFlag);
}
