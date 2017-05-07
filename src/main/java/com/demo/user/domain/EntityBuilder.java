package com.demo.user.domain;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.demo.user.model.User;

public class EntityBuilder {
	
	public static UserEntity getUserEntity(User model){
		
		return UserEntity.getBuilder()
				.withFirstName(model.getFirstName())
				.withLastName(model.getLastName())
				.withDob(convertToLocalDate(model.getDob()))
				.build();
	}
	
	private static LocalDate convertToLocalDate(String date){
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		return dtf.parseLocalDate(date);
	}

}
