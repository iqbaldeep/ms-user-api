package com.demo.user.domain;


import org.springframework.data.repository.CrudRepository;

/**
 * this class uses JPA to connect to DB
 * it extends CrudRepository which makes it a repository ootb
 * CrudRepository exposes default methods to get data from db 
 * and we don't need to implement UserRepository
 * @author Iqbaldeep_Singh
 *
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {



}
