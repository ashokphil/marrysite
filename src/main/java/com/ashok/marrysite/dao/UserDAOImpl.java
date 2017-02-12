package com.ashok.marrysite.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashok.marrysite.model.SearchCriteria;
import com.ashok.marrysite.model.User;



@Repository
@Transactional
public class UserDAOImpl implements userDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    @Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("Person saved successfully, Person Details="+user);
	}

	public void updatePerson(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("Person updated successfully, Person Details="+user);
		
	}

	public List<User> Users() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for(User user : usersList){
			logger.info("Person List::"+user);
		}
		return usersList;
	}


	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println("testttttttttttttttttttttttttttttttttttttttttttttt");
		Session session = this.sessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery("from User where loginname=?");
		query.setParameter(0, username);
		//System.out.println(query.list().size());
		User user=null;
		if(query.list().size()>0){
			
		 user=(User)query.list().get(0);
		 
		}
		
		System.out.println("teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		return user;
	}


	public List<User> searchUsers(SearchCriteria searchcriteria,int firstresult) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		if (searchcriteria.getGender() != null) {
		      crit.add(Restrictions.eq("gender", searchcriteria.getGender()));
		}
		if (searchcriteria.getReligion() != null) {
		      crit.add(Restrictions.eq("religion", searchcriteria.getReligion()));
		}
		crit.setFirstResult(firstresult);
		crit.setMaxResults(firstresult+10);
		
		List<User> users  = crit.list();
		return users;
	}
	
	public void mergeUser(User userexpress){
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(userexpress);
	}


	public Long searchsize(SearchCriteria searchcriteria) {
		
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		if (searchcriteria.getGender() != null) {
		      crit.add(Restrictions.eq("gender", searchcriteria.getGender()));
		}
		if (searchcriteria.getReligion() != null) {
		      crit.add(Restrictions.eq("religion", searchcriteria.getReligion()));
		}
		Long resultcount=(Long)(crit.setProjection(Projections.rowCount()).uniqueResult());
		Long pageno=(resultcount/10)+1;
		return pageno;
	}
	
	}


