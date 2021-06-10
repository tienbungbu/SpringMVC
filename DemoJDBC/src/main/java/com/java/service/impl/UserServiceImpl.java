package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.model.User;
import com.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	public void addUser(User user) {
		dao.addUser(user);
		
	}

	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	public void deleteUser(int id) {
		dao.deleteUser(id);
		
	}

	public User getUserById(int id) {
		
		return dao.getUserById(id);
	}

	public List<User> getAllUsers() {
		
		return dao.getAllUsers();
	}

}
