package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.ProductDTO;
import com.java.service.impl.ProductSerivceImpl;

@RestController
public class RestProductController {
	
	@Autowired
	ProductSerivceImpl productSerivceImpl;
	
	// DANH SACH SAN PHAM THEO REST API theo WEB SERVICES
		@RequestMapping(value = "/danh-sach-san-pham", method = RequestMethod.GET)
		public  List<ProductDTO> listProduct(HttpServletRequest request) {	
			List<ProductDTO> list = productSerivceImpl.getAllProduct();
			return list;
		}
		
		@RequestMapping(value = "/detail/{productID}", method = RequestMethod.GET)
		public  ProductDTO detail(@PathVariable(name = "productID") int productID) {
			ProductDTO p = productSerivceImpl.getProductById(productID);
			return p;
		}
		
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		@ResponseStatus(code = HttpStatus.CREATED)
		public void  addProduct(@RequestBody ProductDTO productDTO) {
			
			productSerivceImpl.addProduct(productDTO);
				
		}
}
