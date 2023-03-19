package com.alumini.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationConfig {

	@Autowired
	Environment env;

	@Primary
	@Bean("dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
		System.out.println(env.getProperty("application.package"));
		Object object = builder.dataSource(dataSource).packages("com.alumini").persistenceUnit("db1").properties(getJPAProps()).build();
		return builder.dataSource(dataSource).packages("com.alumini").persistenceUnit("db1").properties(getJPAProps()).build();
	}

	private Map<String, Object> getJPAProps() {
		// TODO Auto-generated method stub

		Map<String, Object> maps = new HashMap<String, Object>();
		return maps;
	}
	
	 @Bean
     public WebMvcConfigurer corsConfigurer() {
		 return new WebMvcConfigurerAdapter() {
             public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                         .allowedHeaders("*");
             }
         };
     }
}
