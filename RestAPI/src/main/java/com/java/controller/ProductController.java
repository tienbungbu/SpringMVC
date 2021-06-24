package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.dao.impl.ProductDaoImpl;
import com.java.entity.Product;
import com.java.model.ProductDTO;
import com.java.service.impl.ProductSerivceImpl;
import com.java.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	ProductSerivceImpl productSerivceImpl;
	
	@Autowired
	ProductValidator productValidator;

	
	// DANH SACH SAN PHAM
	@RequestMapping(value = "/list-products", method = RequestMethod.GET)
	public String viewListProduct(HttpServletRequest request) {
		
		List<ProductDTO> products = productSerivceImpl.getAllProduct();
		request.setAttribute("products", products);
		
		return "listProducts";
	}
	
	// THEM SAN PHAM
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		
		request.setAttribute("productDTO", new ProductDTO());
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @ModelAttribute("productDTO")ProductDTO productDTO, BindingResult bindingResult) {
		
		productValidator.validate(productDTO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addProduct";
		}
		productSerivceImpl.addProduct(productDTO);
			return "redirect:/list-products";
	}
	
	// CHI TIET SAN PHAM
	@RequestMapping(value = "/detail-product/{productID}", method = RequestMethod.GET)
	public String detailProduct(HttpServletRequest request, @PathVariable(name = "productID") int productID) {
		
		ProductDTO p = productSerivceImpl.getProductById(productID);
		
		request.setAttribute("productDTO", p);
		
		return "detailProduct";
	}
	
	// XOA SAN PHAM
	@RequestMapping(value = "/delete-product/{productID}", method = RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request, @PathVariable(name = "productID") int productID) {
		
		productSerivceImpl.deleteProduct(productID);
		
		return "redirect:/list-products";
	}
	
	//SUA SAN PHAM
	//GET
	@RequestMapping(value = "/edit-product/{productID}", method = RequestMethod.GET)
	public String editProduct(HttpServletRequest request, @PathVariable(name = "productID") int productID) {
		
		ProductDTO productDTO = productSerivceImpl.getProductById(productID);
		request.setAttribute("p", productDTO);
		
		return "editProduct";
	}
	
	//POST
	@RequestMapping(value = "/edit-product", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request, @ModelAttribute("p") ProductDTO p,BindingResult bindingResult) {
		productValidator.validate(p, bindingResult);
		if(bindingResult.hasErrors()) {
			return "editProduct";
		}
		productSerivceImpl.updateProduct(p);
		
		return "redirect:/list-products";
	}
	
}
