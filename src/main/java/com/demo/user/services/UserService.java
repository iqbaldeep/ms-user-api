package com.demo.user.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.user.domain.UserEntity;
import com.demo.user.model.User;

@Service
public interface UserService {
	
	public List <User> getUsers(final String interactionID);
	
	public User addUser(final User user, String interactionID);

}
