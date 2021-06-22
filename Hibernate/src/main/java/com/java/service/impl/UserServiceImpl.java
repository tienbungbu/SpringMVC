package com.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.UserDao;
import com.java.entity.UserEntity;
import com.java.model.User;
import com.java.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	public void addUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setPhoneNumber(user.getPhoneNumber());
		dao.addUser(userEntity);
		
	}

	public void updateUser(User user) {
		UserEntity userEntity = dao.getUserById(user.getId());
		if(userEntity != null) {
			userEntity.setName(user.getName());
			userEntity.setPhoneNumber(user.getPhoneNumber());	
			dao.updateUser(userEntity);
		}
	}

	public void deleteUser(int id) {
		UserEntity userEntity = dao.getUserById(id);
		if(userEntity != null) {
			dao.deleteUser(id);
		}
	}

	public User getUserById(int id) {
		UserEntity userEntity = dao.getUserById(id);
		
		User user = new User();
		user.setId(userEntity.getId());
		user.setName(userEntity.getName());
		user.setPhoneNumber(userEntity.getPhoneNumber());
		
		return user;
	}

	public List<User> getAllUsers() {
		List<UserEntity> userEntitys = dao.getAllUsers();
		List<User> users = new ArrayList<User>() ;
		for(UserEntity userEntity : userEntitys ) {
			User user = new User();
			user.setId(userEntity.getId());
			user.setName(userEntity.getName());
			user.setPhoneNumber(userEntity.getPhoneNumber());
			
			users.add(user);
		}
		return users;
	}

}
