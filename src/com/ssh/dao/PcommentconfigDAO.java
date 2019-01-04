package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.ssh.entity.Pcommentconfig;


@Repository
public class PcommentconfigDAO {
	
	
	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List< Pcommentconfig> getPcommentconfigs(){
		return (List<Pcommentconfig>)this.getSession().createCriteria(Pcommentconfig.class).list();
	}
	
	public void addPcommentconfig(Pcommentconfig pcommentconfig) {
		this.getSession().save(pcommentconfig);
	}
	
    public void updatePcommentconfig(Pcommentconfig pcommentconfig) {
		this.getSession().update(pcommentconfig);
	}

    public void deletePcommentconfig(Pcommentconfig pcommentconfig) {
    	this.getSession().delete(pcommentconfig);
    }
    
	public Pcommentconfig getPcommentconfigById(int id)
	{
		return (Pcommentconfig)this.getSession().createQuery("from Pcommentconfig where pcfid=?").setParameter(0, id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pcommentconfig> getPcommentconfigByPid(int pid)
	{
		return (List<Pcommentconfig>)this.getSession().createQuery("from Pcommentconfig where pid=?").setParameter(0, pid).list();
	}
	
	public Pcommentconfig getPcommentconfigByPUidUnique(int pid,String uid){
		return (Pcommentconfig)this.getSession().createQuery("from Pcommentconfig where pid=? and uid=?").setParameter(0, pid).setParameter(1, uid).uniqueResult();                      
	}
}









