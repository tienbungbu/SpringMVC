package com.java.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.User;

@Controller
public class UserController {
 
	@RequestMapping(value = "/add-user", method = RequestMethod.GET )
	public String addUser(HttpServletRequest req) {
		User user = new User();
		req.setAttribute("user", user);
		return "addUser";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST )
	public String addUser(HttpServletRequest req, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		req.setAttribute("user", user);
		return "viewUser";
	}
	
}
