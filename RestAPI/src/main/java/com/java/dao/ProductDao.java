package com.java.dao;

import java.util.List;

import com.java.entity.Product;


public interface ProductDao {
	
	public void addProduct (Product product);
	
	public void updateProduct (Product product);
	
	public void deleteProduct (int id);
	
	public Product getProductById(int id);
	
	public List<Product> getAllProduct();

}
