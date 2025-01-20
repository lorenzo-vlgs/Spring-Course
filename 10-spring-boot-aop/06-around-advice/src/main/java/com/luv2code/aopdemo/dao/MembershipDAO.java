package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAO implements IMembership{

    @Override
    public boolean addsillyNumber() {
        
        System.out.println(getClass() + ": DOING MY DB WORK - ADDING NUMBER AND IT'S TRUEEEEE\n");

        return true;
    }

}
