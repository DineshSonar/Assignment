package com.uxpsystems.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uxpsystems.assignment.utils.ApplicationConstants;

@Entity
@Table(name = "user_data")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "c_username", unique=true)
	private String username;

	@Column(name = "c_password")
	private String password;

	@Column(name = "c_status")
	private String status;
	
	public User() {

	}

	public User(String username, String password, String status) {
		this.username = username;
		this.password = password;
		this.status = status;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username  + ", status=" + (status.equalsIgnoreCase("1") ? ApplicationConstants.Activated: ApplicationConstants.Deactivated)  + "]";
	}



}