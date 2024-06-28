package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountDAO {
	
	public void addAccount();

	public void updateAccount();
	
	public Integer deleteAccount();
	
	public Integer addAccount(String firstName, String lastName, boolean flag);
	
	public String getName();

	public void setName(String name);

	public String getServiceCode();

	public void setServiceCode(String serviceCode);

	public List<Account> findAccounts();
	
	public List<Account> findAccounts(boolean tripWire);
}
