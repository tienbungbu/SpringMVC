package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.ProductDao;
import com.java.entity.Product;
import com.java.model.ProductDTO;
import com.java.service.ProductService;


@Service

public class ProductSerivceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	public void addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setQuantity(productDTO.getQuantity());
		product.setPrice(productDTO.getPrice());
		
		productDao.addProduct(product);
		
	}

	public void updateProduct(ProductDTO productDTO) {
		Product product = productDao.getProductById(productDTO.getId());
		if(product != null) {
			product.setName(productDTO.getName());
			product.setQuantity(productDTO.getQuantity());
			product.setPrice(productDTO.getPrice());
			 
			productDao.updateProduct(product);
		}
		
	}

	public void deleteProduct(int id) {
		Product product = productDao.getProductById(id);
		if(product != null) {
			productDao.deleteProduct(id);
			}
		}
		
	

	public ProductDTO getProductById(int id) {
		Product product = productDao.getProductById(id);
		
		ProductDTO dto = new ProductDTO();
		
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setQuantity(product.getQuantity());
		dto.setPrice(product.getPrice());
		
		return dto;
	}

	public List<ProductDTO> getAllProduct() {
		List<Product> products = productDao.getAllProduct();
		
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product : products) {
			
			ProductDTO dto = new ProductDTO();
			
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setQuantity(product.getQuantity());
			dto.setPrice(product.getPrice());
			
			productDTOs.add(dto);
		}
		
		return productDTOs;
	}

}
