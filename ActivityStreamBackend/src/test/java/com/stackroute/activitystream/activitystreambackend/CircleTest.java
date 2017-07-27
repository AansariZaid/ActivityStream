package com.stackroute.activitystream.activitystreambackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;

public class CircleTest {

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static Circle circle;

	@Autowired
	private static CircleDAO circleDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
		circle = context.getBean(Circle.class);
		circleDAO = (CircleDAO) context.getBean("circleDAO");
	}

	//@Test
	public void createCircleTest() {
		Circle circle = new Circle();
		circle.setCircleName("Circle1");
		circle.setDescription("this is first Circle");
		circle.setCircleOwner("zaid3891@gmail.com");
		circle.setCreationDate(new Date());
		assertEquals("Circle Crreatedn " ,true,circleDAO.createCicrcle(circle));		
	}
	
	@Test
	public void updateCircleTest()
	{
		circle = circleDAO.getCircleById(1);
		circle.setCircleName("MyCircle");
		assertEquals("Circle Updated",true, circleDAO.updateCircle(circle));
	}
	
	//@Test
	public void deleteCircleTest()
	{
		assertEquals("Circle Deleted",true,circleDAO.deleteCircle(2));
		
	}
	
	@Test
	public void getCircleByIdTest()
	{
		circle = circleDAO.getCircleById(1);
		assertNotNull(circle);
		assertEquals("Circle Retived Correctly","MyCircle", circle.getCircleName());
		display(circle);
	}
	
	@Test
	public void getCircleByName()
	{
		circle = circleDAO.getCircleByName("MyCircle");
		assertNotNull(circle);
		display(circle);
	}
	
	@Test
	public void getAllCircles()
	{
		List<Circle> allCircles = circleDAO.getAllCircles();
		assertNotNull(allCircles);
		for(Circle c: allCircles) display(c);
	}
	
	public void display(Circle circle)
	{
		System.out.println(circle);
	}
	
	
	
}
