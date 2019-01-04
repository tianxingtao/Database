package com.ssh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.ComDao;
import com.ssh.entity.Com;

@Transactional
@Service
public class ComService {

	@Autowired
	private ComDao comdao;
	
	public List<Com>getComs()
	{
		return comdao.getComs();
	}
	
	public void addCom(Com com)
	{
		comdao.addCom(com);
	}
	
	public void updateCom(Com com)
	{
		comdao.updateCom(com);
	}
	
	public void delComById(String id)
	{
		comdao.delComById(id);
	}
	
	public Com getComById(String id)
	{
		return comdao.getComById(id);
	}
}
