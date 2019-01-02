package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.*;

@Repository
public class ProductinfoDAO {
	
	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Productinfo> getProductinfos(){
		return (List<Productinfo>)this.getSession().createCriteria(Productinfo.class).list();
	}
	
	public void addProductinfo(Productinfo productinfo) {
		this.getSession().save(productinfo);
	}
	
    public void updateProductinfo(Productinfo productinfo) {
		this.getSession().update(productinfo);
	}

    public void deleteProductinfo(Productinfo productinfo) {
    	this.getSession().delete(productinfo);
    }
    
	public void delProductinfoById(int id)
	{
		this.getSession().createQuery("delete Productinfo where pid=?").setParameter(0, id).executeUpdate();
	}
	
	public Productinfo getProductinfoById(int id)
	{
		return (Productinfo)this.getSession().createQuery("from Productinfo where pid=?").setParameter(0, id).uniqueResult();
	}
    
	@SuppressWarnings("unchecked")
	public List<Productinfo> getProductinfoByType(String type) {
		return (List<Productinfo>)this.getSession().createQuery("from Productinfo where type=?").setParameter(0, type).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Productinfo> getProductinfoByCid(String cid){
		return (List<Productinfo>)this.getSession().createQuery("from Productinfo where cid=?").setParameter(0, cid).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Productinfo> getProductinfoByHql(String hql){
		return (List<Productinfo>)this.getSession().createQuery(hql).list();
	}
	
}







