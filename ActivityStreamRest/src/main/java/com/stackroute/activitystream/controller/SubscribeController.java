package com.stackroute.activitystream.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.SubscribeDAO;
import com.stackroute.activitystream.model.User;

@RestController
public class SubscribeController {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	SubscribeDAO subscribeDAO;

	@Autowired
	HttpSession session;
	
	public SubscribeController(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@RequestMapping("/subscribeCircle/{circleId}")
	public ResponseEntity<?> subscribeCircle(@PathVariable int circleId)
	{
		try {
			User currentUser = (User) session.getAttribute("currentUser");
			subscribeDAO.subscribeCircle(circleId,currentUser.getEmailid());
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/unSubscribeCircle/{circleId}")
	public ResponseEntity<?> unSubscribeCircle(@PathVariable int circleId)
	{
		try {
			User currentUser = (User) session.getAttribute("currentUser");
			subscribeDAO.unSubscribeCircle(circleId, currentUser.getEmailid());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
