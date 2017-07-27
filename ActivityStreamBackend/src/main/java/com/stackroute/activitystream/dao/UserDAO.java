package com.stackroute.activitystream.dao;

import com.stackroute.activitystream.model.User;

public interface UserDAO {

	public Boolean register(User user);
	public User validate(User user);
	public Boolean Update(User user);
	public Boolean delete(String emailid);
}
