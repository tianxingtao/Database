package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.PshoppingcartDAO;
import com.ssh.entity.Pshoppingcart;

@Transactional
@Service
public class PshoppingcartService {
	
	
	@Autowired
	PshoppingcartDAO pshoppingcartDAO;
	
	public List<Pshoppingcart> getPshoppingcarts()
	{
		return this.pshoppingcartDAO.getPshoppingcarts();
	}
	
	public void addPshoppingcart(Pshoppingcart pshoppingcart)
	{
		this.pshoppingcartDAO.addPshoppingcart(pshoppingcart);
	}
	
	public void updatePshoppingcart(Pshoppingcart pshoppingcart)
	{
		this.pshoppingcartDAO.updatePshoppingcart(pshoppingcart);
	}
	
	public void deletePshoppingcart(Pshoppingcart pshoppingcart)
	{
		this.pshoppingcartDAO.deletePshoppingcart(pshoppingcart);
	}
	
	
	public void delPshoppingcartById(int id)
	{
		this.pshoppingcartDAO.delPshoppingcartById(id);
	}
	
	public Pshoppingcart getPshoppingcartById(int id)
	{
		return this.pshoppingcartDAO.getPshoppingcartById(id);                     
	}
	
	public List<Pshoppingcart> getPshoppingcartByuid(String uid) {
		return this.pshoppingcartDAO.getPshoppingcartByuid(uid);
	}
	
	public void delPshoppingcartByuid(String uid)
	{
		this.pshoppingcartDAO.delPshoppingcartByuid(uid);
	}
}
