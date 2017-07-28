package com.stackroute.activitystream.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.model.Circle;

@Repository("circleDAO")
@Transactional
public class CircleDAOImpl implements CircleDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CircleDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Boolean createCicrcle(Circle circle) {

		try {
			circle.setCreationDate(new Date());
			circle.setCircleStatus("A");
			sessionFactory.getCurrentSession().persist(circle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean updateCircle(Circle circle) {
		try {
			
			sessionFactory.getCurrentSession().update(circle);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteCircle(int circleId) {
		try {
			Circle circle = getCircleById(circleId);
			if (circle != null) {
				circle.setCircleStatus("N");
				sessionFactory.getCurrentSession().update(circle);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Circle getCircleById(int circleId) {
		try {
			Circle circle = sessionFactory.getCurrentSession().get(Circle.class, circleId);
			return circle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Circle getCircleByName(String name) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Circle where circleName = ?");
			query.setParameter(0, name);
			Circle circle = (Circle) query.uniqueResult();
			return circle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Circle> getAllCircles() {

		try {
			List<Circle> Allcircles = sessionFactory.getCurrentSession().createQuery("from Circle").list();
			return Allcircles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
