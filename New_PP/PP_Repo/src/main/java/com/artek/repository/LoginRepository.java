package com.artek.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.artek.model.User;

@Repository
public class LoginRepository {
	
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
/*public User repoLogic(User user)
{
	System.out.println("Inside login repository");
	System.out.println(user.getEmail());
	System.out.println(user.getPassword());
	return user;
}
*/

public boolean userSignIn(User user)
{
	System.out.println("Inside login repository");
	
	List<User> login=(List<User>) hibernatetemplate.find("from User where email=? and password=?",user.getEmail(),user.getPassword());
	
	if(login.isEmpty())
	{
		return true;
	}
	return false;
}
} 
