package com.ssh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="orderinfo")
public class Orderinfo {
	
	private int oid;
	
	private String uid;
	
	private int pid;
	
	private Date time;
	
	private int num;
	
	private float price;
	
	private String address;
	
	@Id
	@Column(name="oid")
	public int getOid() {
		return oid;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	@Column(name="uid")
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Column(name="pid")
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Column(name="time")
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Column(name="num")
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	@Column(name="price")
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Orderinfo(int oid, String uid, int pid, Date time, int num, float price, String address) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.pid = pid;
		this.time = time;
		this.num = num;
		this.price = price;
		this.address = address;
	}

	public Orderinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
