package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entities.Account;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {

			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			demoAfterReturningAdvice(accountDAO);
			
			};
			
	}
			
	
	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		
		// call a method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();

		//display the accounts
		System.out.println("\n\nMain Program: demoAfterReturningAdvice()");
		System.out.println("-------");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		
		// call the business method
		System.out.println("\n");
		Account account = new Account("Mario", "VIP");
		accountDAO.addAccount(account, false);
		accountDAO.doWork();

		System.out.println("\n");
		//call the accountDao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		System.out.println("\n");
		membershipDAO.addsillyNumber();
	}
}
