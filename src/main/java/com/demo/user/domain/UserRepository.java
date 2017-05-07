package com.demo.user.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.user.domain.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	List<UserEntity> findByLastName(String lastName);
	
//	List<UserEntity> findAll();

}
