package com.stackroute.activitystream.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		try {
			User newUser = userDAO.register(user);
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> validateUser(@RequestBody User user, HttpSession sesssion) {
		try {
			User validUser = userDAO.validate(user);
			sesssion.setAttribute("currentUser", validUser);
			return new ResponseEntity<User>(validUser, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "/logout",method = RequestMethod.DELETE)
	public ResponseEntity<?> logoutUser(HttpSession session)
	{
		User user = (User) session.getAttribute("currentUser");
		if(user != null)
		{
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	@RequestMapping(value = "/fetchAllUsers" , method = RequestMethod.GET)
	public ResponseEntity<List<User>> fetchAllUser()
	{
		List<User> Allusers = userDAO.fetchAllUser();
		if(Allusers != null)
		{
			return new ResponseEntity<List<User>>(Allusers,HttpStatus.OK);
		}else
		{
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "/fetchUser", method = RequestMethod.GET)
	public ResponseEntity<?> fetchUser(HttpSession session)
	{
		User user = (User) session.getAttribute("currentUser");
		if(user != null)
		{
			user = userDAO.fetchUserById(user.getUId());
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else
		{
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
}
