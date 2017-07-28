package com.stackroute.activitystream.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping(value="/updatecircle")
	public ResponseEntity<?> updateCircle(@RequestBody Circle circle)
	{
		try
		{
			circleDAO.updateCircle(circle);
			return new ResponseEntity<Circle>(circle,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("deleteCircle")
	public ResponseEntity<?> deleteCircle(@RequestBody int circleId)
	{
		try
		{
			circleDAO.deleteCircle(circleId);
			return new ResponseEntity<Integer>(circleId,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/getallcircles")
	public ResponseEntity<?> getAllCircles()
	{
		try
		{
			List<Circle> allCircles=circleDAO.getAllCircles();
			return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

}
