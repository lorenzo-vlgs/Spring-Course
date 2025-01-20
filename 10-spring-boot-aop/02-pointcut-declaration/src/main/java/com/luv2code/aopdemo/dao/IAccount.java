package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.entities.Account;

public interface IAccount {
    
    void addAccount(Account account, boolean vipFlag);

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    void setServiceCode(String serviceCode);
}
