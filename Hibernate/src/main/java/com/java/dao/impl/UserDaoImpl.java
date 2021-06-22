package com.java.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.UserDao;
import com.java.entity.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addUser(UserEntity user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	public void updateUser(UserEntity user) {
		sessionFactory.getCurrentSession().merge(user);
	}

	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));
		
	}

	public UserEntity getUserById(int id) {
		return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
	}

	public List<UserEntity> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		
		return criteria.list();

}
}
