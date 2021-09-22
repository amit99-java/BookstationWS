package com.example.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@Column
	private String userAddress;
	@Column
	private int userPhoneno;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int userId, String userName, String userAddress, int userPhoneno) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhoneno = userPhoneno;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserPhoneno() {
		return userPhoneno;
	}
	public void setUserPhoneno(int userPhoneno) {
		this.userPhoneno = userPhoneno;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", userPhoneno="
				+ userPhoneno + "]";
	}
	
	
	
	

}
