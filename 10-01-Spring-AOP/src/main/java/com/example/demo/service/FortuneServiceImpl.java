package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFurtune() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Just started.");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Just ended.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expecting delay for 5 seconds. ";
	}

	@Override
	public String getFurtune(boolean tripWire) {
		// TODO Auto-generated method stub

		try {
			if (tripWire) 
				throw new RuntimeException("You have an exception.");

			return getFurtune();
		} catch ( Exception e) {
			System.out.println("In getFurtune : " + e.getMessage());
			throw e;
		}
	}
}
