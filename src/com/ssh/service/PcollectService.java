package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.PcollectDAO;
import com.ssh.entity.Pcollection;


@Transactional
@Service
public class PcollectService {

	@Autowired
	PcollectDAO pcollectDAO;
	
	public List<Pcollection> getPcollections()
	{
		return this.pcollectDAO.getPcollections();
	}
	
	public void addPcollection(Pcollection pcollection)
	{
		this.pcollectDAO.addPcollection(pcollection);
	}
	
	public void updatePcollection(Pcollection pcollection)
	{
		this.pcollectDAO.updatePcollection(pcollection);
	}
	
	public void deletePcollection(Pcollection pcollection)
	{
		this.pcollectDAO.deletePcollection(pcollection);
	}
	
	
	public void delPcollectionById(int id)
	{
		this.pcollectDAO.delPcollectionById(id);
	}
	
	public Pcollection getPcollectionById(int id)
	{
		return this.getPcollectionById(id);
	}
	
	public List<Pcollection> getPcollectionByuid(String uid) {
		return this.pcollectDAO.getPcollectionByuid(uid);
	}
}
