package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="productinfo")
public class Productinfo {
	private int pid;
	
	private String pname;
	
	private String type;
	
	private float price;
	
	private String introduce;
	
	private String cid;
	
	private int pnum;
	
	private String pstatus;
	
	private String picturelocation;
	
	private int pview;
	
	private int pbuynum;

	@Id
	@Column(name="pid")
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name="pname")
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name="introduce")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(name="cid")
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Column(name="pnum")
	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	@Column(name="pstatus")
	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	@Column(name="picturelocation")
	public String getPicturelocation() {
		return picturelocation;
	}

	public void setPicturelocation(String picturelocation) {
		this.picturelocation = picturelocation;
	}

	@Column(name="pview")
	public int getPview() {
		return pview;
	}

	public void setPview(int pview) {
		this.pview = pview;
	}

	@Column(name="pbuynum")
	public int getPbuynum() {
		return pbuynum;
	}

	public void setPbuynum(int pbuynum) {
		this.pbuynum = pbuynum;
	}

	public Productinfo(int pid, String pname, String type, float price, String introduce, String cid, int pnum,
			String pstatus, String picturelocation, int pview, int pbuynum) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.type = type;
		this.price = price;
		this.introduce = introduce;
		this.cid = cid;
		this.pnum = pnum;
		this.pstatus = pstatus;
		this.picturelocation = picturelocation;
		this.pview = pview;
		this.pbuynum = pbuynum;
	}

	public Productinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
		
}
