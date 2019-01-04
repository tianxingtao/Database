package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	
	private String uid;
	
	private String password;
	
	private String type;
	
	private String phone;

	@Id
	@Column(name="uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String uid,String password,String type,String phone)
	{
		this.setUid(uid);
		this.setPassword(password);
		this.setType(type);
		this.setPhone(phone);
	}

}
