package com.demo.user.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.user.model.User;

@RequestMapping("/v1")
public interface UsersApi {

	/**
	 * GET method exposed to get list of all users saved in db
	 * @param interactionID unique parameter for each transaction used for tracing a request
	 * @return
	 */
	@RequestMapping(value = "/users",
			produces = { "application/json" }, 
			consumes = { "application/json" },
			method = RequestMethod.GET)
	List <User>  usersGet(@RequestHeader(value="interactionId", required=true) String interactionID);
	
	/**
	 * POST method to save a user in db
	 * @param interactionID unique parameter for each transaction used for tracing a request
	 * @param user user object to be saved
	 * @return
	 */
	@RequestMapping(value = "/addUser",
			produces = { "application/json" }, 
			consumes = { "application/json" },
			method = RequestMethod.POST)
	User addUserPost( @RequestHeader(value="interactionId", required=true) String interactionID,
			@RequestBody(required=true) User user);

}
