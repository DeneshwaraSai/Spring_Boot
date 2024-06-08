package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class JDBCSecurityConfig {
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		try {
			http.authorizeHttpRequests(configurer -> 
				configurer
					.requestMatchers("/").hasRole("MANAGER")
					.requestMatchers("/leaders/**").hasRole("MANAGER")
					.requestMatchers("/systems/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				)
			.formLogin(form -> 
					form.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				)
			.logout(logout -> logout.permitAll())
			.exceptionHandling(configurer -> 
				configurer.accessDeniedPage("/access-denied")
				);
			
			return http.build();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
