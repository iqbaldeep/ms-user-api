package com.demo.user.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.Application;
import com.demo.user.domain.EntityBuilder;
import com.demo.user.domain.UserEntity;
import com.demo.user.domain.UserRepository;
import com.demo.user.model.ModelBuilder;
import com.demo.user.model.User;

/**
 * implementation of UserService
 * @author Iqbaldeep_Singh
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List <User> getUsers(final String interactionID) {
		LOG.debug("Finding all users. interactionID={}", interactionID);
		
		//call repository and get all records in table
		Iterable<UserEntity> allUserEntities = userRepository.findAll();
		
		//convert Iterable to a parallel stream 
		List <User> allUsers = StreamSupport.stream(allUserEntities.spliterator(), true).map(
				
				//build model for each entity. In process, convert Date to human readable format
				userEntity -> ModelBuilder.getUserModel(userEntity)
			
				//collect mapped model objects as a List
		).collect(Collectors.toList());

		return allUsers;
				
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User addUser(final User user, String interactionID){
		LOG.debug("Adding user={}. interactionID={}", user, interactionID);
		
		//convert model to entity and save in db
		UserEntity savedUserEntity = userRepository.save(EntityBuilder.getUserEntity(user));
		
		//convert received entity back to model and return
		return ModelBuilder.getUserModel(savedUserEntity);
	}

}
