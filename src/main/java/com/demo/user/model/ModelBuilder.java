package com.demo.user.model;

import org.joda.time.LocalDate;

import com.demo.user.domain.UserEntity;

/**
 * this class is used to convert all entities to models 
 * It uses builder pattern to build new objects cleanly 
 * @author Iqbaldeep_Singh
 *
 */
public class ModelBuilder {
	
	/**
	 * builds User model object from UserEntity
	 * @param entity
	 * @return
	 */
	public static User getUserModel(UserEntity entity){
		
		//build and return model
		return User.getBuilder()
				.withId(entity.getId())
				.withFirstName(entity.getFirstName())
				.withLastName(entity.getLastName())
				.withDob(getReadableDate(entity.getDob()))
				.build();
		
	}
	
	/**
	 * gets date in human readable form. This is to avoid any date conversions on frontend
	 * @param date from DB
	 * @return human readable date string in format MM/dd/yyyy
	 */
	private static String getReadableDate(LocalDate date){
		String readableDate = null;
		//convert only if non-null
		if(null != date){
			//convert date to readable form
			readableDate = date.toString("MM/dd/yyyy");
		}
		
		return readableDate;
	}

}
