package com.ssh.controller;

import com.ssh.entity.Orderinfo;
import com.ssh.entity.Productinfo;

public class Orderproduct {
	public Orderinfo orderinfo;
	public Productinfo productinfo;
	public Orderproduct(Orderinfo orderinfo, Productinfo productinfo) {
		super();
		this.orderinfo = orderinfo;
		this.productinfo = productinfo;
	}
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	public Productinfo getProductinfo() {
		return productinfo;
	}
	public void setProductinfo(Productinfo productinfo) {
		this.productinfo = productinfo;
	}
	public Orderproduct() {
		super();
		// TODO Auto-generated constructor stub
	}
}
