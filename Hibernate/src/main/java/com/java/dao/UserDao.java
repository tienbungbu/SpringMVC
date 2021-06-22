package com.java.dao;

import java.util.List;

import com.java.entity.UserEntity;

public interface UserDao {
	public void addUser (UserEntity user);
	
	public void updateUser (UserEntity user);
	
	public void deleteUser (int id);
	
	public UserEntity getUserById (int id);
	
	public List<UserEntity> getAllUsers() ;
}
