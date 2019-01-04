package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Com;

@Repository
public class ComDao {

	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Com>getComs()
	{
		return this.getSession().createCriteria(Com.class).list();
	}
	
	public void addCom(Com com)
	{
		this.getSession().save(com);
	}
	
	public void updateCom(Com com)
	{
		this.getSession().update(com);
	}
	
	public void delComById(String id)
	{
		this.getSession().createQuery("delete Com where cid=?").setParameter(0, id).executeUpdate();
	}
	
	public Com getComById(String id)
	{
		return (Com)this.getSession().createQuery("from Com where cid=?").setParameter(0, id).uniqueResult();
	}
}
