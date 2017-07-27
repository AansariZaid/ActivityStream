package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Circle;

public interface CircleDAO {
	
	Boolean createCicrcle(Circle circle);
	Boolean updateCircle(Circle circle);
	Boolean deleteCircle(int circleId);
	Circle getCircleById(int circleId);
	Circle getCircleByName(String name);
	List<Circle> getAllCircles();
	
}
