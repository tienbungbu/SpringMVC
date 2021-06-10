	package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.User;
import com.java.service.UserService;
import com.java.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public String viewListUser(HttpServletRequest req) {
		
		List<User> users =  userService.getAllUsers();
		
		req.setAttribute("users", users);
		
		return "user/viewListUser";
	}
	
	@RequestMapping(value = "/detail-user/{userID}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest req, @PathVariable(name = "userID") int userID) {
		
		User user = userService.getUserById(userID);
		
		req.setAttribute("user", user);
		
		return "user/viewUser";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest req) {
		req.setAttribute("user", new User());
		return "user/addUser";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(HttpServletRequest req, 
			@ModelAttribute("user") User user, BindingResult bindingResult ) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "user/addUser";
		}
		
		userService.addUser(user);
		
		return "redirect:/list-user";
	}
	
	@RequestMapping(value = "/delete-user/{userID}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest req, @PathVariable("userID") int userID ) {
		
		userService.deleteUser(userID);
		
		return "redirect:/list-user";
	}
	
	@RequestMapping(value = "/update-user/{userID}", method = RequestMethod.GET)
	public String updateUser(HttpServletRequest req, @PathVariable("userID") int userID) {
		req.setAttribute("user", userService.getUserById(userID));
		
		return "user/updateUser";
	}
	
	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest req, @ModelAttribute("user") User user, BindingResult bindingResult ) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "user/updateUser";
		}
		
		userService.updateUser(user);
		
		return "redirect:/list-user";
	}
}
