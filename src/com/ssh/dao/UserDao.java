package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.User;


@Repository
public class UserDao {

	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers()
	{
		return this.getSession().createCriteria(User.class).list();
	}
	
	public void addUser(User user)
	{
		this.getSession().save(user);
	}
	
	public void updateUser(User user)
	{
		this.getSession().update(user);
	}
	
	public void delUserById(String id)
	{
		this.getSession().createQuery("delete User where pid=?").setParameter(0, id).executeUpdate();
	}
	
	public User getUserById(String id)
	{
		return (User)this.getSession().createQuery("from User where pid=?").setParameter(0, id).uniqueResult();
	}
}
