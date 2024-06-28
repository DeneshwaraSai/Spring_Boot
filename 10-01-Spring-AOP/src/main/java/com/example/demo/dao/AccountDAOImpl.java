package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	
	private String serviceCode;

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT.");
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: UPDATE AN ACCOUNT.");
	}

	@Override
	public Integer deleteAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: DELETE AN ACCOUNT.");
		return null;
	}

	public String getName() {
		System.out.println(getClass() + " : DOING MY DB WORK: getName");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass() + " : DOING MY DB WORK: setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : DOING MY DB WORK: getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : DOING MY DB WORK: setServiceCode");
		this.serviceCode = serviceCode;
	}

	@Override
	public Integer addAccount(String firstName, String lastName, boolean flag) {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: addAccount(String firstName, String lastName, boolean flag)");
		System.out.println("FirstName : " + firstName + " | Lastname : " + lastName + " | flag : " + flag);
		return null;
	}

	@Override
	public List<Account> findAccounts() {
		// TODO Auto-generated method stub
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		// TODO Auto-generated method stub
		if (tripWire) {
			throw new RuntimeException("There is an Error in finding accounts.") ;
		}
		
		List<Account> accounts = new ArrayList<Account>();

		accounts.add(new Account("John Patrick", "Silver"));
		accounts.add(new Account("Ravi prakash", "Silver"));
		accounts.add(new Account("Luca Madhu", "Silver"));
		
		System.out.println("In implemented method : \n" + accounts.toString());
		
		return accounts;
	}
}
