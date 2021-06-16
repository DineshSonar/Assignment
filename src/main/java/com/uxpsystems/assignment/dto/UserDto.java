package com.uxpsystems.assignment.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import com.uxpsystems.assignment.utils.ApplicationConstants;

public class UserDto {
	
	private long id;
	
	@NotNull
	@Size(min=2, max=16, message= ApplicationConstants.UsernameValid)
	private String username;
	@NotNull
	@Size(min=2, max=16, message=ApplicationConstants.PasswordValid)
	private CharSequence password;
	@NotNull
	private String status;
	
	private String message;
	
	public UserDto(){
		
	}
	
	public UserDto(long id, String username, CharSequence password, String status,String message) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.message = message;
	}
	
	public UserDto(String message) {
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CharSequence getPassword() {
		return password;
	}
	public void setPassword(CharSequence password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "UserDto [username=" + username  + ", status=" + (status.equalsIgnoreCase("1") ? ApplicationConstants.Activated: ApplicationConstants.Deactivated)  + "]";
	}
}
