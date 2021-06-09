package com.java.springmvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.model.User;

@Controller
public class UserController {

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest req) {
		User user = new User();

		req.setAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(HttpServletRequest req, @ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			@RequestParam(name = "avatar") MultipartFile avatar) {
		//messages errors
		if(bindingResult.hasErrors()) {
			return "addUser";
		}
		
		// luu xuong o cung
		try {
			File saveFile = new File("E:\\SaveFile\\" + avatar.getOriginalFilename());
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(saveFile);

			fileOutputStream.write(avatar.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// da luu xuong o cung

		req.setAttribute("avatar", avatar);
		req.setAttribute("user", user);
		return "viewUser";
	}

}
