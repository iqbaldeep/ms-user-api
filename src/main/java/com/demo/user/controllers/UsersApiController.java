package com.demo.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.api.UsersApi;
import com.demo.user.model.User;
import com.demo.user.services.UserService;

import io.swagger.annotations.ApiParam;;

/**
 * Controller that receives and routes all api calls
 * @RestController annotation makes it a controller. 
 * We use it so that we can return our object rather than ResponseEntity<?>
 * @CrossOrigin annotation used to allow cross-origin access to this api
 * @author Iqbaldeep_Singh
 *
 */
@CrossOrigin(origins = {"http://localhost:3000","http://138.68.224.242"})
@RestController
public class UsersApiController implements UsersApi{
	
	@Autowired
	private UserService userService;


	@Override
	public List <User> usersGet(@ApiParam(value = "Unique identifier for transaction, passed from UI" ,required=true ) 
	@RequestHeader(value="interactionId", required=true) String interactionID) {
		
		//call to service layer
		List <User> users = userService.getUsers(interactionID);

		return users;
	}

	@Override
	public User addUserPost(@RequestHeader(value="interactionId", required=true) String interactionID, 
			@RequestBody( required=true ) User user) {
		
		//call to service layer
		User savedUser = userService.addUser(user, interactionID);
		return savedUser;
	}

}
