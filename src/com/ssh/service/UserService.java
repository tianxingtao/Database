package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	
	public List<User>getUsers()
	{
		return userdao.getUsers();
	}
	
	public void addUser(User user)
	{
		userdao.addUser(user);
	}
	
	public void updateUser(User user)
	{
		userdao.updateUser(user);
	}
	
	public void delUserById(String id)
	{
		userdao.delUserById(id);
	}
	
	public User getUserById(String id)
	{
		return userdao.getUserById(id);
	}
}
