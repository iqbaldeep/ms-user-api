package com.demo.user.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.user.domain.UserEntity;
import com.demo.user.domain.UserRepository;
import com.demo.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	UserRepository mockedRepository;
	
	Iterable <UserEntity> allUsersIterable;
	
	UserEntity userEntity;
	
	@Before
	public void setUp() throws Exception {
		List <UserEntity> users = new ArrayList<>();
		
		userEntity = new UserEntity( "Tom", "Cruise", new LocalDate());
		
		users.add(userEntity);
		
		allUsersIterable = () -> users.iterator();
	}
	
	@Test
	public void testGetUsers_NoDataInDB(){
		
		when(mockedRepository.findAll()).thenReturn(null);
		
		List<User> users = userService.getUsers("123456");
		
		assertEquals(0, users.size());
		
		
		
	}
	
	@Test
	public void testGetUsers_SomeRecords(){
		
		when(mockedRepository.findAll()).thenReturn(allUsersIterable);
		
		List<User> users = userService.getUsers("123456");
		
		assertEquals(1, users.size());
		
	}
	
	@Test
	public void testAddUser_NullUser(){
		
		when(mockedRepository.save(Mockito.any(UserEntity.class))).thenReturn(null);
		
		User user = userService.addUser(new User(), "123456");
		
		assertNull(user);
		
	}
	
	@Test
	public void testAddUser_SomeUser(){
		
		when(mockedRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
		
		User user = userService.addUser(new User(), "123456");
		
		assertNotNull(user);
		assertEquals(userEntity.getFirstName(), user.getFirstName());
		assertEquals(userEntity.getLastName(), user.getLastName());
		assertEquals(userEntity.getId(), user.getId());
		
	}
}
