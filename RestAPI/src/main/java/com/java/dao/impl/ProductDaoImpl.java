package com.java.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.ProductDao;
import com.java.entity.Product;
import com.java.model.ProductDTO;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);
		
	}

	public void deleteProduct(int id) {
		sessionFactory.getCurrentSession().delete(getProductById(id));
		
	}

	public Product getProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public List<Product> getAllProduct() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		
		return criteria.list();
	}
	
}
