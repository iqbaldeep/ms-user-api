package com.demo.user.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List <User> getUsers(final String interactionID) {
		LOG.debug("Finding all users. interactionID={}", interactionID);
		
		Iterable<UserEntity> allUserEntities = userRepository.findAll();
		
		List <User> allUsers = StreamSupport.stream(allUserEntities.spliterator(), true).map(
				
				userEntity -> ModelBuilder.getUserModel(userEntity)
			
		).collect(Collectors.toList());

		return allUsers;
				
	}
	
	public User addUser(final User user, String interactionID){
		LOG.debug("Adding user={}. interactionID={}", user, interactionID);
		
		UserEntity savedUserEntity = userRepository.save(EntityBuilder.getUserEntity(user));
				
		return ModelBuilder.getUserModel(savedUserEntity);
	}

}
