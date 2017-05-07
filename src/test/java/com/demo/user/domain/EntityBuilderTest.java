	package com.demo.user.domain;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityBuilderTest {
	
	User model;
	@Before
	public void setUp() throws Exception {
		model = new User(1L, "firstname", "lastname", "2017-12-30");
	}
	
	@Test
	public void testGetUserEntity_InstanceOf(){
		
		Object obj = EntityBuilder.getUserEntity(model);
		assertThat(obj, instanceOf(UserEntity.class));
	}
	
	@Test
	public void testGetUserEntity_NullDate(){
		model.setDob(null);
		UserEntity entity = EntityBuilder.getUserEntity(model);
		
		assertNull(entity.getDob());
		
	}
	
	@Test
	public void testGetUserEntity_FirstName(){
		UserEntity entity = EntityBuilder.getUserEntity(model);
		
		assertEquals("firstname", entity.getFirstName());
		
	}
	
	@Test
	public void testGetUserEntity_LastName(){
		UserEntity entity = EntityBuilder.getUserEntity(model);
		
		assertEquals("lastname", entity.getLastName());
		
	}
	
	@Test
	public void testConvertToLocalDate_NullDate(){
		LocalDate localdate = EntityBuilder.convertToLocalDate(null);
		
		assertNull(localdate);
		
	}
	
	@Test
	public void testConvertToLocalDate_NonNullDate(){
		LocalDate localdate = EntityBuilder.convertToLocalDate("2017-12-30");
		
		assertNotNull(localdate);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertToLocalDate_DateFormat(){
		LocalDate localdate = EntityBuilder.convertToLocalDate("12-30-2017");
		
		assertNotNull(localdate);
		
	}
	
	@Test
	public void testConvertToLocalDate_BlankDate(){
		LocalDate localdate = EntityBuilder.convertToLocalDate("");
		
		assertNull(localdate);
		
	}

}
