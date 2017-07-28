package com.stackroute.activitystream.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.model.SubscribeCircle;

@Transactional
@Repository("subscribeDAO")
public class SubscribeDAOImpl implements SubscribeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	SubscribeCircle subscribeCircle;

	public SubscribeDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Boolean subscribeCircle(int circleId, String userEmailId) {

		try {
			// checking if subscription already exists
			SubscribeCircle alreadySubscribed = getSubscription(circleId, userEmailId);

			//move in and subscribe if not alreadySubscribed
			if (alreadySubscribed == null) {
				subscribeCircle.setCircleId(circleId);
				subscribeCircle.setEmailId(userEmailId);
				sessionFactory.getCurrentSession().save(subscribeCircle);
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean unSubscribeCircle(int circleId, String userEmailId) {

		try {
			//checking whether subscription exists or not
			subscribeCircle = getSubscription(circleId, userEmailId);
			
			// Unsubscribe if Subscription exists
			if (subscribeCircle != null) {
				subscribeCircle.setStatus("N");
				sessionFactory.getCurrentSession().update(subscribeCircle);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private SubscribeCircle getSubscription(int circleId, String userEmailId) {
		try {

			Query query = sessionFactory.getCurrentSession()
					.createQuery("from SubscribeCircle where circleId = ? and emailId = ? and status = ?");
			query.setParameter(0, circleId);
			query.setParameter(1, userEmailId);
			query.setParameter(3, "A");
			SubscribeCircle subscribedCircle = (SubscribeCircle) query.uniqueResult();
			return subscribedCircle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<SubscribeCircle> getMySubscription(String emailId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from SubscribeCircle where emailId = ? and status = ?");
			query.setParameter(0, emailId);
			query.setParameter(1, "A");
			
			List<SubscribeCircle> mySubscriptions = query.list();
			return mySubscriptions;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
