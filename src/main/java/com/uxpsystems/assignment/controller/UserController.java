package com.uxpsystems.assignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.dto.UserDto;
import com.uxpsystems.assignment.exception.FatalException;
import com.uxpsystems.assignment.logger.ServiceLogger;
import com.uxpsystems.assignment.service.UserService;

@RestController
@RequestMapping("/assignment")
public class UserController {

	@Autowired
	UserDao userDao;

	@Autowired
	UserService userService;

	//private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * @param id
	 * @return
	 * @throws FatalException
	 */
	@GetMapping("/user")
	public ResponseEntity<UserDto> getUserById(@RequestBody UserDto userDto) throws FatalException {

		ServiceLogger.info("Request received for get inside method getUserById");
		UserDto userDtoResp = userService.findUserDataById(userDto.getId());

		if (null != userDtoResp) {
			return new ResponseEntity<>(userDtoResp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param userDto
	 * @return
	 * @throws FatalException
	 */
	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) throws FatalException {
		ServiceLogger.info("Request received for get inside method createUser");
		UserDto userDtoResp = userService.saveUser(userDto);
		return new ResponseEntity<>(userDtoResp, HttpStatus.CREATED);
	}

	/**
	 * @param userDto
	 * @return
	 */
	@PutMapping("/user")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
		ServiceLogger.info("Request received for get inside method updateUser");
		UserDto userDtoResp = userService.updateUserData(userDto);
		return new ResponseEntity<>(userDtoResp, HttpStatus.OK);

	}

	/**
	 * @return
	 */
	@DeleteMapping("/user")
	public ResponseEntity<UserDto> deleteAllUser() {
		ServiceLogger.info("Request received for get inside method deleteAllUser");
		try {
			UserDto userDtoResp = userService.deleteAllUserData();
			return new ResponseEntity<>(userDtoResp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
