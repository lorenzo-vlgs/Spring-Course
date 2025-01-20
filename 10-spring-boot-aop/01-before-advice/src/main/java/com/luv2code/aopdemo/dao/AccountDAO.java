package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.entities.Account;

@Repository
public class AccountDAO implements IAccount{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        
        System.out.println(getClass() + ": DOING MY DB WORK - ADDING ACCOUNT\n");
    }

}
