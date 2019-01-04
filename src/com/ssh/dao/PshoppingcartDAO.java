package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Pshoppingcart;



@Repository
public class PshoppingcartDAO {
	
	
	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pshoppingcart> getPshoppingcarts()
	{
		return this.getSession().createCriteria(Pshoppingcart.class).list();
	}
	
	public void addPshoppingcart(Pshoppingcart pshoppingcart)
	{
		this.getSession().save(pshoppingcart);
	}
	
	public void updatePshoppingcart(Pshoppingcart pshoppingcart)
	{
		this.getSession().update(pshoppingcart);
	}
	
	public void deletePshoppingcart(Pshoppingcart pshoppingcart)
	{
		this.getSession().delete(pshoppingcart);
	}
	
	
	public void delPshoppingcartById(int id)
	{
		this.getSession().createQuery("delete Pshoppingcart where psid=?").setParameter(0, id).executeUpdate();
	}
	
	public Pshoppingcart getPshoppingcartById(int id)
	{
		return (Pshoppingcart)this.getSession().createQuery("from Pshoppingcart where psid=?").setParameter(0, id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pshoppingcart> getPshoppingcartByuid(String uid) {
		return (List<Pshoppingcart>)this.getSession().createQuery("from Pshoppingcart where uid=?").setParameter(0, uid).list();
	}
	
	public void delPshoppingcartByuid(String uid)
	{
		this.getSession().createQuery("delete Pshoppingcart where uid=?").setParameter(0, uid).executeUpdate();
	}
	
}
