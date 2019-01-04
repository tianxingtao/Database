package com.ssh.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="com")
public class Com {

	private String cid;
	
    private String password;
	
	private String address;
	
	private String phone;
	
	@Id
	@Column(name="cid")
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Com() {
		
	}
	
	public Com(String cid,String password,String address,String phone)
	{
		this.setCid(cid);
		this.setPassword(password);
		this.setAddress(address);
		this.setPhone(phone);
	}
	
}
