package com.artek.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.artek.model.User;

@Repository
public class RegistrationRepository {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public boolean emailVerifyAndSubmit(User user)
	{
	    	List list=hibernateTemplate.find("from User where email=?", user.getEmail());
	    	if(!list.isEmpty())
	    	{
	    		return true;
	    	}		
	     return false;		
	}
	
	public void register(User user)
	{
		// hibernateTemplate.save(user); ****** assining foreignkey NULL***********
		Session session=hibernateTemplate.getSessionFactory().openSession(); 
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();		
		System.out.println("registration success");
	}
}
