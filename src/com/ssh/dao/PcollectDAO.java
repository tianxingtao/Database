package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Pcollection;


@Repository
public class PcollectDAO {

	
	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pcollection> getPcollections()
	{
		return this.getSession().createCriteria(Pcollection.class).list();
	}
	
	public void addPcollection(Pcollection pcollection)
	{
		this.getSession().save(pcollection);
	}
	
	public void updatePcollection(Pcollection pcollection)
	{
		this.getSession().update(pcollection);
	}
	
	public void deletePcollection(Pcollection pcollection)
	{
		this.getSession().delete(pcollection);
	}
	
	
	public void delPcollectionById(int id)
	{
		this.getSession().createQuery("delete Pcollection where pcid=?").setParameter(0, id).executeUpdate();
	}
	
	public Pcollection getPcollectionById(int id)
	{
		return (Pcollection)this.getSession().createQuery("from Pcollection where pcid=?").setParameter(0, id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pcollection> getPcollectionByuid(String uid) {
		return (List<Pcollection>)this.getSession().createQuery("from Pcollection where uid=?").setParameter(0, uid).list();
	}
	
	
}
