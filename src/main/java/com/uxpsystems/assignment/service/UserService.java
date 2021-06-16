package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.dto.UserDto;
import com.uxpsystems.assignment.exception.FatalException;

public interface UserService {

	/**
	 * @param userDto
	 * @throws FatalException
	 */
	UserDto saveUser(UserDto userDto) throws FatalException;

	/**
	 * @param id
	 * @return
	 * @throws FatalException
	 */
	UserDto findUserDataById(long id) throws FatalException;

	/**
	 * @return 
	 * 
	 */
	UserDto deleteAllUserData();

	/**
	 * @param userDto
	 * @return 
	 */
	UserDto updateUserData(UserDto userDto);

}
