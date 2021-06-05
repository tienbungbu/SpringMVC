package com.java.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.Product;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/add-product",method = RequestMethod.GET)
	public String addProduct(HttpServletRequest req) {
		Product product = new Product();
		req.setAttribute("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value = "/add-product",method = RequestMethod.POST)
	public String addProduct(HttpServletRequest req, @ModelAttribute("product")Product product) {
		req.setAttribute("product", product);
		return "viewProduct";
	}
	
}
