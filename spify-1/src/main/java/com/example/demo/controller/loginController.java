package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;
import com.example.demo.repository.userRepository;

@Controller

public class loginController {
	@Autowired
	private userRepository userRespository;
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	private String LoginForm(Model model) {
		model.addAttribute("userlogin",new User());
		return "login";
	}
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	private String userLogin(@ModelAttribute User user, Model model) {
		if(userRespository.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			model.addAttribute("un",user.getUsername());
			return "home";
		}
		model.addAttribute("msg","user not found!!");
		model.addAttribute("username",new User());
		return "login";
	}
	

}
