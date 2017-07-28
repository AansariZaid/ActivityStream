package com.stackroute.activitystream.activitystreambackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.SubscribeDAO;

public class SubscribeCircleTest {

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static SubscribeDAO subscribeDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
		subscribeDAO = (SubscribeDAO) context.getBean("subscribeDAO");
	}

//	@Test
	public void subscribeTest() {
		assertEquals(true, subscribeDAO.subscribeCircle(1, "zaid3891@gmail.com"));
	}

	@Test
	public void unSubscribeTest() {
		assertEquals(true, subscribeDAO.unSubscribeCircle(1, "zaid3891@gmail.com"));
	}

}
