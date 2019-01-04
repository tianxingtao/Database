package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.OrderinfoDAO;
import com.ssh.entity.Orderinfo;


@Transactional
@Service
public class OrderinfoService {

	
	@Autowired
	private OrderinfoDAO orderinfoDAO;

	
	public List<Orderinfo> getOrderinfos(){
		return this.orderinfoDAO.getOrderinfos();
	}
	
	
	public void addOrderinfo(Orderinfo orderinfo) {
		this.orderinfoDAO.addOrderinfo(orderinfo);
	}
	
	
    public void updateOrderinfo(Orderinfo orderinfo) {
		this.orderinfoDAO.updateOrderinfo(orderinfo);
	}

    
    public void deleteOrderinfo(Orderinfo orderinfo) {
    	this.orderinfoDAO.deleteOrderinfo(orderinfo);
    }
    
    
	public void delOrderinfoById(int oid)
	{
		this.orderinfoDAO.delOrderinfoById(oid);
	}
	
	
	public Orderinfo getOrderinfoById(int oid)
	{
		return this.orderinfoDAO.getOrderinfoById(oid);
	}
    
    
	public List<Orderinfo> getOrderinfoByUid(String uid){
		return this.orderinfoDAO.getOrderinfoByUid(uid);
	}
	
	
	public List<Orderinfo> getOrderinfoByPid(int pid){
		return this.orderinfoDAO.getOrderinfoByPid(pid);              
	}
	
	
}
