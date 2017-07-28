package com.stackroute.activitystream.activitystreambackend;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.SubscribeDAO;
import com.stackroute.activitystream.model.SubscribeCircle;

public class SubscribeCircleTest {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SubscribeCircle subscribeCircle;
	
	@Autowired
	private static SubscribeDAO subscribeDAO;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
		subscribeCircle = context.getBean(SubscribeCircle.class);
		subscribeDAO = (SubscribeDAO) context.getBean("subscribeDAO");
	}
	
	@Test
	public void subscribeTest()
	{
		
	}
	
}
