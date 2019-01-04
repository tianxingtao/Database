package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	private int pnid;
	private int pnum;
	
	@Id
	@Column(name="pnid")
	public int getPnid() {
		return pnid;
	}
	
	public void setPnid(int pnid) {
		this.pnid = pnid;
	}
	
	@Column(name="pnum")
	public int getPnum() {
		return pnum;
	}
	
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
	
}
