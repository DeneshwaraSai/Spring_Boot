package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfig {
	
	/*
	 * This is to implement InMemory Spring Security for authorizing REST API
	 * Just Uncomment the @Bean to execute
	 * */
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails user1 = User.builder()
								.username("John")
								.password("{noop}test123")
								.roles("MANAGER", "LEAD")
								.build();

		UserDetails user2 = User.builder()
								.username("Ricky")
								.password("{noop}test123")
								.roles("MANAGER")
								.build();

		UserDetails user3 = User.builder()
								.username("Mary")
								.password("{noop}test123")
								.roles("SDE")
								.build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/employees/all").hasAnyRole("MANAGER")  
				.requestMatchers(HttpMethod.GET, "/employees/**").hasAnyRole("MANAGER", "LEAD")  
				.requestMatchers(HttpMethod.PUT, "/employees/**").hasRole("LEAD")
				.requestMatchers(HttpMethod.POST, "/employees/**").hasRole("SDE")
				.requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("LEAD")
			);

		// For basic Auth
		http.httpBasic(Customizer.withDefaults());

		/*
		 * CSRF - Cross Site Request Forgery
		 * In general, not required 
		 * Useful for stateless REST APIs that use POST, PUT, DELETE and PATCH
		 * */
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}
