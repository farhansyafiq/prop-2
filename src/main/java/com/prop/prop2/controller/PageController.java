package com.prop.prop2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prop.prop2.model.RoleModel;
import com.prop.prop2.model.UserModel;
import com.prop.prop2.service.RoleService;
import com.prop.prop2.service.UserService;

@Controller
public class PageController {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home(HttpServletRequest httpServletRequest, Model model) {
		if(httpServletRequest.isUserInRole("ADMIN")) {
			List<RoleModel> listOfRoles = roleService.listRole();
			model.addAttribute("listOfRoles", listOfRoles);
			return "home";
		}
		
		else if(httpServletRequest.isUserInRole("SALESREPRESENTATIVE")) {
			return "home-salesrep";
		}
		
		else if(httpServletRequest.isUserInRole("AREASALESHEAD")) {
			return "home-areasaleshead";
		}
		
		else {
			return "test";
		}

	}
	
	@RequestMapping("/login")
		public String login() {
			return "login";
	}
	
	@RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute UserModel user, Model model) {
		userService.addUser(user);
		return "home";
	}
}
