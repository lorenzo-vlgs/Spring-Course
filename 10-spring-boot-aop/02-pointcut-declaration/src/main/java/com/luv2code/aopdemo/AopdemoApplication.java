package com.luv2code.aopdemo;

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

			demoTheBeforeAdvice(accountDAO, membershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		
		// call the business method
		System.out.println("\n");
		Account account = new Account();
		accountDAO.addAccount(account, false);

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
