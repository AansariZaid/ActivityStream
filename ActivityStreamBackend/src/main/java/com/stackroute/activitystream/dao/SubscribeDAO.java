package com.stackroute.activitystream.dao;

public interface SubscribeDAO {

	Boolean subscribeCircle(int circleId,String userEmailId);
	Boolean unSubscribeCircle(int circleId,String userEmailId);
	
}
