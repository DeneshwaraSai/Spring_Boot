package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomJDBCSecurityConfig {
	
	@Bean
	public UserDetailsManager detailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		
		// Define how to retrieve parent table - users/members data by user-Id
		manager.setUsersByUsernameQuery("SELECT USER_ID, PASSWORD, ACTIVE FROM MEMBERS WHERE USER_ID = ?");
		
		// Define how to retrieve child table - authorities/role table data by user-Id
		manager.setAuthoritiesByUsernameQuery("SELECT USER_ID, ROLE FROM ROLES WHERE USER_ID = ?");
		
		return manager;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		try {
			http.authorizeHttpRequests(configurer -> 
				configurer
					.requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
			        .requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
			        .requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
			        .requestMatchers(HttpMethod.PUT, "/employees").hasRole("MANAGER")
			    .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
			);
			
			return http.build();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return null;
		}
	}
}
