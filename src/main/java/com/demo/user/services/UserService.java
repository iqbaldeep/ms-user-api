package com.demo.user.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.user.model.User;

/**
 * service interface to interact with DB and massage data as required by
 * API consumers
 * @author Iqbaldeep_Singh
 *
 */
@Service
public interface UserService {
	
	/**
	 * gets list of all users from repository layer and massages as per requirement of api consumers
	 * @param interactionID unique parameter for each transaction used for tracing a request
	 * @return list of User objects
	 */
	public List <User> getUsers(final String interactionID);
	
	/**
	 * 
	 * @param user
	 * @param interactionID unique parameter for each transaction used for tracing a request
	 * @return User object newly created
	 */
	public User addUser(final User user, String interactionID);

}
