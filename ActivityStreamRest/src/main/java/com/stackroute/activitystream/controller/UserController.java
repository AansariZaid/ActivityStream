package com.stackroute.activitystream.controller;

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
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		try {
			userDAO.register(user);
			user.setStatusMessage("User Registered Sucessfully");
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			user.setStatusMessage("User Registration Failed");
			return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> validateUser(@RequestBody User user) {
		try {
			User validUser = userDAO.validate(user);
			session.setAttribute("currentUser", validUser);
			return new ResponseEntity<User>(validUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public ResponseEntity<?> logoutUser() {
		User user = (User) session.getAttribute("currentUser");
		if (user != null) {
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
}
