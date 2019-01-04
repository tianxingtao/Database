package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Pcomment;

@Repository
public class PcommentDAO {
	
	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Pcomment> getPcomments(){
		return (List<Pcomment>)this.getSession().createCriteria(Pcomment.class).list();
	}
	
	public void addPcomment(Pcomment Pcomment) {
		this.getSession().save(Pcomment);
	}
	
    public void updatePcomment(Pcomment Pcomment) {
		this.getSession().update(Pcomment);
	}

    public void deletePcomment(Pcomment Pcomment) {
    	this.getSession().delete(Pcomment);
    }
    
	public Pcomment getPcommentById(int id)
	{
		return (Pcomment)this.getSession().createQuery("from Pcomment where pcoid=?").setParameter(0, id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pcomment> getPcommentByPUid(int pid,String uid){
		return (List<Pcomment>)this.getSession().createQuery("from Pcomment where pid=? and uid=?").setParameter(0, pid).setParameter(1, uid).list();                          
	}
	
	public Pcomment getPcommentByPUidUnique(int pid,String uid){
		return (Pcomment)this.getSession().createQuery("from Pcomment where pid=? and uid=?").setParameter(0, pid).setParameter(1, uid).uniqueResult();                      
	}
	
	@SuppressWarnings("unchecked")
	public List<Pcomment> getPcommentByPid(int pid){
		return (List<Pcomment>)this.getSession().createQuery("from Pcomment where pid=?").setParameter(0, pid).list();                          
	}
}




