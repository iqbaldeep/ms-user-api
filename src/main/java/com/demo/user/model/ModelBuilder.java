package com.demo.user.model;

import org.joda.time.LocalDate;

import com.demo.user.domain.UserEntity;

public class ModelBuilder {
	
	public static User getUserModel(UserEntity entity){
		
		return User.getBuilder()
				.withId(entity.getId())
				.withFirstName(entity.getFirstName())
				.withLastName(entity.getLastName())
				.withDob(getReadableDate(entity.getDob()))
				.build();
		
	}
	
	private static String getReadableDate(LocalDate date){
		return date.toString("MM/dd/yyyy");
	}

}
