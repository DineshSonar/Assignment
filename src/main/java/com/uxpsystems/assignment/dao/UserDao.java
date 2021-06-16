package com.uxpsystems.assignment.dao;

import com.uxpsystems.assignment.model.User;


public interface UserDao {

	/**
	 * @param user
	 * @return
	 */
	User saveData(User user);

	/**
	 * @param id
	 * @return
	 */
	User findUserDataById(long id);

	/**
	 * 
	 */
	void deleteAllUserData();

}
