package com.demo.user.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.user.domain.UserEntity;
import com.demo.user.model.User;

@RequestMapping("/v1")
public interface UsersApi {

    
	@RequestMapping(value = "/users",
			produces = { "application/json" }, 
			consumes = { "application/json" },
			method = RequestMethod.GET)
	List <User>  usersGet(@RequestHeader(value="interactionId", required=true) String interactionID);

	@RequestMapping(value = "/addUser",
			produces = { "application/json" }, 
			consumes = { "application/json" },
			method = RequestMethod.POST)
	User addUserPost( @RequestHeader(value="interactionId", required=true) String interactionID,
			@RequestBody(required=true) User user);

}
