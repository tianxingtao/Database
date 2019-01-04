package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.PcommentconfigDAO;
import com.ssh.entity.Pcommentconfig;



@Transactional
@Service
public class PcommentconfigService {

	@Autowired
	private PcommentconfigDAO pcommentconfigDAO;
	
	public List< Pcommentconfig> getPcommentconfigs(){
		return this.pcommentconfigDAO.getPcommentconfigs();
	}
	
	public void addPcommentconfig(Pcommentconfig pcommentconfig) {
		this.pcommentconfigDAO.addPcommentconfig(pcommentconfig);
	}
	
    public void updatePcommentconfig(Pcommentconfig pcommentconfig) {
    	this.pcommentconfigDAO.updatePcommentconfig(pcommentconfig);
	}

    public void deletePcommentconfig(Pcommentconfig pcommentconfig) {
    	this.pcommentconfigDAO.deletePcommentconfig(pcommentconfig);
    }
    
	public Pcommentconfig getPcommentconfigById(int id)
	{
		return this.pcommentconfigDAO.getPcommentconfigById(id);
	}
	
	public List<Pcommentconfig> getPcommentconfigByPid(int pid)
	{
		return this.pcommentconfigDAO.getPcommentconfigByPid(pid);
	}
	
	public Pcommentconfig getPcommentconfigByPUidUnique(int pid,String uid){
		return this.pcommentconfigDAO.getPcommentconfigByPUidUnique(pid, uid);                      
	}
}
