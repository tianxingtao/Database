package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Orderinfo;

@Repository
public class OrderinfoDAO {

	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orderinfo> getOrderinfos(){
		return (List<Orderinfo>)this.getSession().createCriteria(Orderinfo.class).list();
	}
	
	
	public void addOrderinfo(Orderinfo orderinfo) {
		this.getSession().save(orderinfo);
	}
	
    public void updateOrderinfo(Orderinfo orderinfo) {
		this.getSession().update(orderinfo);
	}

    public void deleteOrderinfo(Orderinfo orderinfo) {
    	this.getSession().delete(orderinfo);
    }
    
	public void delOrderinfoById(int oid)
	{
		this.getSession().createQuery("delete Orderinfo where oid=?").setParameter(0, oid).executeUpdate();
	}
	
	public Orderinfo getOrderinfoById(int oid)
	{
		return (Orderinfo)this.getSession().createQuery("from Orderinfo where oid=?").setParameter(0, oid).uniqueResult();
	}
    
    
	@SuppressWarnings("unchecked")
	public List<Orderinfo> getOrderinfoByUid(String uid){
		return (List<Orderinfo>)this.getSession().createQuery("from Orderinfo where uid=?").setParameter(0, uid).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orderinfo> getOrderinfoByPid(int pid){
		return (List<Orderinfo>)this.getSession().createQuery("from Orderinfo where pid=?").setParameter(0, pid).list();
	}
	
	
}






