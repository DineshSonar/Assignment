package com.uxpsystems.assignment.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.dao.UserDaoSupport;
import com.uxpsystems.assignment.model.User;

@Repository("userDaoImpl")
public class UserDaoImpl  implements UserDao{

	@Autowired
	UserDaoSupport userDaoSupport;
	
	@Override
	public User saveData(User user) {
		return userDaoSupport.save(user);
	}
	
	@Override
	public User findUserDataById(long id) {
		return userDaoSupport.getById(id);
	}
	
	@Override
	public void deleteAllUserData() {
		 userDaoSupport.deleteAll();
	}
	
}
