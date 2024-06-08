package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfig {

//	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		System.out.println("In SecurityConfig.InMemoryUserDetailsManager");
		
		UserDetails user1 = User.builder()
								.username("Dinesh")
								.password("{noop}test123")
								.roles("MANAGER")
								.build();
		
		UserDetails user2 = User.builder()
								.username("sai")
								.password("{noop}test123")
								.roles("EMPLOYEE")
								.build();
		
		UserDetails user3 = User.builder()
								.username("ila")
								.password("{noop}test123")
								.roles("MANAGER", "EMPLOYEE", "ADMIN")
								.build();
		
		return new InMemoryUserDetailsManager(user1, user2, user3);
	}
	
//	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		try {
		/* 	http.authorizeHttpRequests(configurer -> 
					configurer.anyRequest().authenticated()
				)
			.formLogin(form -> 
				form	
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				)
			.logout(logout -> logout.permitAll());
			*/
			
			System.out.println("In SecurityConfig.SecurityFilterChain");
			
			http.authorizeHttpRequests(configurer -> 
				configurer
					.requestMatchers("/").hasRole("EMPLOYEE")
					.requestMatchers("/leaders/**").hasRole("MANAGER")
					.requestMatchers("/systems/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				)
			.formLogin(form -> 
				form
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				)
			.logout(logout -> logout.permitAll())
			.exceptionHandling(configurer -> 
				configurer.accessDeniedPage("/access-denied")
			);
			
			return http.build();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
}
