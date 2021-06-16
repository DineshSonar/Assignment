package com.uxpsystems.assignment;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.uxpsystems.assignment.dao.impl.UserDaoImpl;
import com.uxpsystems.assignment.dto.UserDto;
import com.uxpsystems.assignment.exception.FatalException;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@MockBean
	private UserDaoImpl userDaoImpl;

	@Test
	@Rollback(true)
	public void testFindByIdDao() {
		User user = getUserObject();
		User userResp = userDaoImpl.findUserDataById(user.getId());
		if(null != userResp){
		assertEquals(user.getUsername(), userResp.getUsername());
		assertEquals(user.getPassword(), userResp.getPassword());
		assertEquals(user.getStatus(), userResp.getStatus());
		}
	}

	@Test
	@Rollback(true)
	public void testSaveDao() {
		User user = getUserObject();
		user.setId(0);
		User userresp = userDaoImpl.saveData(user);
		if(null != userresp){
		assertEquals(user.getUsername(), userresp.getUsername());
		assertEquals(user.getPassword(), userresp.getPassword());
		assertEquals(user.getStatus(), userresp.getStatus());
		}
	}

	@Test
	@Rollback(true)
	public void testDeleteUserDao() {
		userDaoImpl.deleteAllUserData();
	}

	@Test
	@Rollback(true)
	public void testFindByIdService() throws FatalException {
		UserDto userDto = getUserDtoObject();
		userDto.setId(1);
		UserDto userResp = userServiceImpl.findUserDataById(userDto.getId());

	}

	@Test
	@Rollback(true)
	public void testSaveService() throws FatalException {
		UserDto userDto = getUserDtoObject();
		userDto.setId(0);
		userServiceImpl.saveUser(userDto);

	}

	@Test
	@Rollback(true)
	public void testDeleteUserService() {
		userServiceImpl.deleteAllUserData();
	}

	public User getUserObject() {
		User user = new User();
		user.setId(5);
		user.setUsername("Test");
		user.setPassword("ABC123");
		user.setStatus("Activted");
		return user;
	}

	public UserDto getUserDtoObject() {
		UserDto userDto = new UserDto();
		userDto.setId(5);
		userDto.setUsername("Test");
		userDto.setPassword("ABC123");
		userDto.setStatus("Activted");
		return userDto;
	}

	@Test
	public void contextLoads() {
	}

}
