package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class JDBCSecurityConfig {

	@Bean 
	public UserDetailsManager detailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
	            .requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
	            .requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
	            .requestMatchers(HttpMethod.PUT, "/employees").hasRole("MANAGER")
	            .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
			);
		
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
