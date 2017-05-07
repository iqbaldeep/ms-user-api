package com.demo.user;


import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.user.domain.UserEntity;
import com.demo.user.domain.UserRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	public static void main(String [] args){
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner saveUsersOnAppLoad(UserRepository repository) {
		return (args) -> {
			// add few users to DB on app bootstrap
			repository.save(new UserEntity( "Tom", "Cruise", new LocalDate()));
			repository.save(new UserEntity( "Ed", "Harris", new LocalDate()));
			repository.save(new UserEntity( "Johnny", "Depp", new LocalDate()));
			repository.save(new UserEntity( "Hugh", "Jackman", new LocalDate()));
			repository.save(new UserEntity( "Matt", "Damon", new LocalDate()));
			
			LOG.debug("Users saved successfully on app bootstrap");
			
		};
	}

}