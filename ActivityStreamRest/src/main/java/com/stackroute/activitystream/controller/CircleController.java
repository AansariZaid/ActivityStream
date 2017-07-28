package com.stackroute.activitystream.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;

@Controller
public class CircleController {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CircleDAO circleDAO;

	public CircleController(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@PostMapping("/createCircle")
	public ResponseEntity<?> createCircle(@RequestBody Circle circle) {
		try {
			circleDAO.createCicrcle(circle);
			return new ResponseEntity<Circle>(circle, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("getCircle/{id}")
	public ResponseEntity<Circle> getCircleById(@PathVariable int id) {
		try {
			return new ResponseEntity<Circle>(circleDAO.getCircleById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
