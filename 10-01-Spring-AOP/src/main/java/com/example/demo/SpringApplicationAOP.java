package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.entity.Account;
import com.example.demo.service.FortuneService;

@SpringBootApplication
public class SpringApplicationAOP {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationAOP.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, 
			MembershipDAO membershipDAO, FortuneService fortuneService) {
		return runner -> {
			System.out.println("Hello World.");
			//			
			//			beforeAdviceAddAccount(accountDAO, membershipDAO);
			//			
			//			beforeAdviceUpdateAccount(accountDAO, membershipDAO);
			//			
			//			deleteAccount(accountDAO, membershipDAO);

			//			testGettersAndSetters(accountDAO, membershipDAO);

			//			findAccounts(accountDAO, membershipDAO);

			//			checkExceptionInFindAccounts(accountDAO);

			//			executeFortuneService(fortuneService);

			checkExceptionInFortuneService(fortuneService);
		}; 
	}

	private void beforeAdviceAddAccount(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub
		accountDAO.addAccount();

		membershipDAO.addAccount();
	}

	private void beforeAdviceUpdateAccount(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub
		membershipDAO.updateAccount();
	}

	private void deleteAccount(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.deleteAccount();
	}

	private void testGettersAndSetters(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub

		accountDAO.setName("Dinesh");
		accountDAO.setServiceCode("CS101");

		membershipDAO.updateAccount();
		accountDAO.deleteAccount();
		accountDAO.addAccount("Deneshwara Sai", "Ila", true);

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
	}


	private void findAccounts(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub

		System.out.println("In findAccounts");
		System.out.println(accountDAO.findAccounts());
		System.out.println("Done");
	}


	private void checkExceptionInFindAccounts(AccountDAO accountDAO) {
		// TODO Auto-generated method stub
		List<Account> accounts = null;

		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Got an exception in : checkExceptionInFindAccounts : " + e.getMessage());
		} finally {
			System.out.println("Done");
		}
	}

	private void executeFortuneService(FortuneService fortuneService) {
		// TODO Auto-generated method stub
		System.out.println(fortuneService.getFurtune()); 
	}
	
	private void checkExceptionInFortuneService(FortuneService fortuneService) {
		// TODO Auto-generated method stub
		
		try {
			boolean tripWire = true;
			String result = fortuneService.getFurtune(tripWire);
			System.out.println(result); 
		} catch (Exception e) {
			System.out.println("In Spring start : Got an exception in : checkExceptionInFortuneService : " + e.getMessage());
		} finally {
			System.out.println("Done with checkExceptionInFortuneService");
		}
	}
}
