package com.luv2code.aopdemo.dao;

import java.util.List;

import com.luv2code.aopdemo.entities.Account;

public interface IAccount {
    
    void addAccount(Account account, boolean vipFlag);

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

}
