package com.ssh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.ProductsDAO;
import com.ssh.entity.Products;

@Transactional
@Service
public class ProductsService {
	
	@Autowired
	private ProductsDAO productsDAO;

	
	public Products getProductsById(int id)
	{
		return this.productsDAO.getProductsById(id);
	}
	
    public void updateProducts(Products products) {
		this.productsDAO.updateProducts(products);
	}
	
}
