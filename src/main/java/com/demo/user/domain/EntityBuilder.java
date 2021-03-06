package com.demo.user.domain;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import com.demo.user.model.User;


/**
 * builds entities from models using builder pattern
 * @author Iqbaldeep_Singh
 *
 */
public class EntityBuilder {
	
	/**
	 * creates UserEntity object from User entity object
	 * @param entity
	 * @return
	 */
	public static UserEntity getUserEntity(User model){
		//build entity and return
		return UserEntity.getBuilder()
				.withFirstName(model.getFirstName())
				.withLastName(model.getLastName())
				.withDob(convertToLocalDate(model.getDob()))
				.build();
	}
	
	/**
	 * parses date sent by api consumer to format required by database
	 * @param date
	 * @return
	 */
	static LocalDate convertToLocalDate(String date){
		LocalDate localdate = null;
		
		//parse only if date is non-null
		if( ! StringUtils.isEmpty(date)){
			//create formatter as per input format
			DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
			
			//convert date string to LocalDate
			localdate = dtf.parseLocalDate(date);
		}
		
		
		return localdate;
	}

}
