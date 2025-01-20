package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.entities.Account;

@Repository
public class AccountDAO implements IAccount{

    private String name;

    private String serviceCode;
    
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK - ADDING ACCOUNT\n");
    }

    public String getName() {
        System.out.println(getClass() + " : getName() method called\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName() method called\n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : getServiceCode() method called\n");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode() method called\n");
        this.serviceCode = serviceCode;
    }

    
}
