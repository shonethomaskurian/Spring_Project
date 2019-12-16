package com.shone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shone.model.Login;
import com.shone.model.Register;
import com.shone.service.UserService;

@Controller

public class RegisterController {
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv=new ModelAndView("welcome");
		return mv;
	}
	@RequestMapping("register")
	public String register() {
		return "register";

}
	@RequestMapping("registration")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response, Register user) {	
		userService.Register(user);
		System.out.println("hi");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

@RequestMapping("login")
public String login()
{
	return "login";
	}
@RequestMapping(value="/signin",method=RequestMethod.POST)
public ModelAndView login(HttpServletRequest request,HttpServletResponse response, Login login)
{
	ModelAndView ma=null;
	Register user=userService.validateUser(login);
	if(null!=user) {
		ma=new ModelAndView("home");
		ma.addObject("firstname",user.getFirstname());
		System.out.println("login action");
	}
	else
	{
		ma=new ModelAndView("login");
		
	}
	return ma;
}
}
	