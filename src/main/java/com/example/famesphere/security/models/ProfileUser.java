package com.example.famesphere.security.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileUser {

	@Id
	private String userid;
	private String password;
	
	public ProfileUser() {
		
	}
	
	public ProfileUser(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
