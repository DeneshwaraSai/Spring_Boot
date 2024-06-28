package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT.");
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: UPDATIG AN MEMBERSHIP ACCOUNT.");
	}

}
