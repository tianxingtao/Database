package com.ssh.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Products;

@Repository
public class ProductsDAO {
	
	@Resource
	private SessionFactory sessionfactory;
	

	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}
	
	public Products getProductsById(int id)
	{
		return (Products)this.getSession().createQuery("from Products where pnid=?").setParameter(0, id).uniqueResult();
	}
	
    public void updateProducts(Products products) {
		this.getSession().update(products);
	}
	
}
