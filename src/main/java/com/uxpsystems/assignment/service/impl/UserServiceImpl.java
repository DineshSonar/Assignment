package com.uxpsystems.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.dto.UserDto;
import com.uxpsystems.assignment.exception.FatalException;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;
import com.uxpsystems.assignment.utils.ApplicationConstants;
import com.uxpsystems.assignment.utils.CryptoUtil;
import com.uxpsystems.assignment.utils.StringUtil;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	CryptoUtil cryptoUtil;

	@Autowired
	StringUtil stringUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uxpsystems.assignment.service.UserService#saveUser(com.uxpsystems.
	 * assignment.dto.UserDto)
	 */
	@Override
	public UserDto saveUser(UserDto userDto) throws FatalException {
		
		if(!isvalidStatus(userDto)){
			return new UserDto(ApplicationConstants.StatusIncorrect);
		}
		
		User user = new User(userDto.getUsername(), cryptoUtil.getShaEncryptedValue(userDto.getPassword()),
				stringUtil.isActive(userDto.getStatus().trim()));
		try {
			User usersaved = userDao.saveData(user);
			userDto.setId(usersaved.getId());
			userDto.setPassword(cryptoUtil.getShaEncryptedValue(userDto.getPassword()));
			userDto.setMessage("Record added successfully.");
			return userDto;
		} catch (Exception e) {
			return new UserDto("Record already available.");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uxpsystems.assignment.service.UserService#findUserDataById(long)
	 */
	@Override
	public UserDto findUserDataById(long id) throws FatalException {
		try {
			User user = userDao.findUserDataById(id);
			return new UserDto(user.getId(), user.getUsername(), user.getPassword(),
					stringUtil.isActive(user.getStatus().trim()), ApplicationConstants.RecordAdded);
		} catch (Exception e) {
			return new UserDto(ApplicationConstants.RecordNotAvailable);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uxpsystems.assignment.service.UserService#deleteAllUserData()
	 */
	@Override
	public UserDto deleteAllUserData() {
		try {
			userDao.deleteAllUserData();
			return new UserDto(ApplicationConstants.RecordDeletedAll);
		} catch (Exception e) {
			return new UserDto(ApplicationConstants.RecordNotDeleted);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uxpsystems.assignment.service.UserService#updateUserData(com.
	 * uxpsystems.assignment.dto.UserDto)
	 */
	@Override
	public UserDto updateUserData(UserDto userDto) {
		User user = null;
		if(!isvalidStatus(userDto)){
			return new UserDto(ApplicationConstants.StatusIncorrect);
		}
		try {
			user = userDao.findUserDataById(userDto.getId());
			if (null != user) {
				user.setPassword(cryptoUtil.getShaEncryptedValue(userDto.getPassword()));
				user.setUsername(userDto.getUsername());
				user.setStatus(stringUtil.isActive(userDto.getStatus().trim()));
				User userupdated = userDao.saveData(user);
				return new UserDto(userupdated.getId(), userupdated.getUsername(), userupdated.getPassword(),
						stringUtil.isActive(userupdated.getStatus().trim()), ApplicationConstants.RecordUpdated);
			} else {
				userDto.setMessage(ApplicationConstants.RecordNotUpdated);
				return userDto;
			}
		} catch (Exception e) {
			userDto.setMessage(ApplicationConstants.RecordNotAvailable);
			return userDto;
		}
	}
	
	public boolean isvalidStatus(UserDto userDto){
		boolean isValid =false;
		if(null != userDto && null != userDto.getStatus() && !"".equalsIgnoreCase(userDto.getStatus())
				&& (ApplicationConstants.Activated.equalsIgnoreCase(userDto.getStatus())
						|| ApplicationConstants.Deactivated.equalsIgnoreCase(userDto.getStatus()))){
			isValid = true;
		}
		return isValid;
	}
}
