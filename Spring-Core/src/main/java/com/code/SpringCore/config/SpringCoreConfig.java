package com.code.SpringCore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.code.SpringCore.service.Coach;
import com.code.SpringCore.service.SwimCoach;

@Configuration
public class SpringCoreConfig {
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
	
	@Bean("swinCoachId")
	public Coach customSwinBean() {
		return new SwimCoach();
	}
}
