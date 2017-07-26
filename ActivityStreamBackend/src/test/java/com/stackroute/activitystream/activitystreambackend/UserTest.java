package com.stackroute.activitystream.activitystreambackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.User;

public class UserTest {

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
		user = context.getBean(User.class);
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	//@Test
	public void registerTest() {
		user.setPhoneNumber("9022484348");
		user.setEmailid("ansari.zaid1@niit.com");
		user.setFirstName("Ansari1");
		user.setLastName("Zaid");
		user.setPassword("zaid@123");
		user.setStatus("A");
		assertEquals("User Registered Sucessfully", true, userDAO.register(user));
	}

	@Test
	public void updateTest()
	{
		user.setPhoneNumber("9022484348");
		user .setFirstName("Aansari");
		user.setLastName("Zaid");
		user.setEmailid("ansari.zaid1@niit.com");
		user.setPassword("zaid@123");
		user.setStatus("A");
		assertEquals("User Updated Sucessfully",true ,userDAO.Update(user));
	}

	//@Test
	public void validateTest() {
		user.setEmailid("zaid@gmial.com");
		user.setPassword("zaid@123");
		assertEquals("User Validated", User.class, userDAO.validate(user).getClass());
		
	}
	
}
