package com.stackroute.activitystream.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Boolean register(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			//log.debug("User Registration Failed");
			return false;
		}
	}

	public User validate(User user) {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from User where emailid = ? and password = ?");
			query.setParameter(0, user.getEmailid());
			query.setParameter(1, user.getPassword());
			user = (User) query.uniqueResult();
			log.debug("User :: " + user.getFirstName()+user.getLastName() + " is a Valid User");
			return user;
		} catch (Exception e) {
			log.debug("Invalid User Account");
			return null;
		}
	}
	
	public Boolean Update(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public Boolean delete(String emailid) {
		
		try
		{
			User updateUser = getUser(emailid);
			updateUser.setStatus("N");
			sessionFactory.getCurrentSession().update(updateUser.getEmailid(),updateUser);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	private User getUser(String emailid) {
		
		try {
			User user = (User) sessionFactory.getCurrentSession().get(User.class, emailid);
			return user;
		}catch (Exception e) {
			return null;
		}
	}

}
