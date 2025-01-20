package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
    
    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }
    
    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        List<Account> accounts = new ArrayList<>();
        // create sample accounts
        Account temp1 = new Account("Luigi", "Silver");
        Account temp2 = new Account("Franco", "Platinum");
        Account temp3 = new Account("Luca", "Gold");
        
        // add them to our accounts list
        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);
        
        return accounts;
    }

    public void doWork(){
        System.out.println(getClass() + ": DOING MY WORK - WORKING");
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
