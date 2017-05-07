package com.demo.user.model;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.user.domain.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelBuilderTest {

	
	UserEntity entity;
	LocalDate localDate;
	@Before
	public void setUp() throws Exception {
		localDate = new LocalDate();
		entity = new UserEntity("firstname", "lastname", localDate);
	}
	
	@Test
	public void testGetUserEntity_InstanceOf(){
		
		Object obj = ModelBuilder.getUserModel(entity);
		assertThat(obj, instanceOf(User.class));
	}
	
	@Test
	public void testGetUserEntity_NullDate(){
		entity.setDob(null);
		User model = ModelBuilder.getUserModel(entity);
		
		assertNull(model.getDob());
		
	}
	
	@Test
	public void testGetUserEntity_FirstName(){
		User model = ModelBuilder.getUserModel(entity);
		
		assertEquals("firstname", model.getFirstName());
		
	}
	
	@Test
	public void testGetUserEntity_LastName(){
		User model = ModelBuilder.getUserModel(entity);
		
		assertEquals("lastname", model.getLastName());
		
	}
	
	@Test
	public void testConvertToLocalDate_NullDate(){
		String date = ModelBuilder.getReadableDate(null);
		
		assertNull(date);
		
	}
	
	@Test
	public void testConvertToLocalDate_NonNullDate(){
		String date = ModelBuilder.getReadableDate(this.localDate);
		
		assertNotNull(date);
		
	}



}
