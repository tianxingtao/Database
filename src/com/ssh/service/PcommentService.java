package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.PcommentDAO;
import com.ssh.entity.Pcomment;


@Transactional
@Service
public class PcommentService {
	
	@Autowired
	private PcommentDAO pcommentDAO;
	
	
	public List<Pcomment> getPcomments(){
		return this.pcommentDAO.getPcomments();                                
	}
	
	public void addPcomment(Pcomment Pcomment) {
		this.pcommentDAO.addPcomment(Pcomment);
	}
	
    public void updatePcomment(Pcomment Pcomment) {
		this.pcommentDAO.updatePcomment(Pcomment);
	}

    public void deletePcomment(Pcomment Pcomment) {
    	this.pcommentDAO.deletePcomment(Pcomment);
    }
    
	public Pcomment getPcommentById(int oid)
	{
		return this.pcommentDAO.getPcommentById(oid);
	}
	
	public List<Pcomment> getPcommentByPUid(int pid,String uid){
		return this.pcommentDAO.getPcommentByPUid(pid,uid);
	}
	
	public Pcomment getPcommentByPUidUnique(int pid,String uid){
		return this.pcommentDAO.getPcommentByPUidUnique(pid, uid);                     
	}
	
	public List<Pcomment> getPcommentByPid(int pid){
		return this.pcommentDAO.getPcommentByPid(pid);                          
	}
}
