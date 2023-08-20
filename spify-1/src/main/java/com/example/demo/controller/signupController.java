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
public class signupController {
	
	@Autowired
	private userRepository UserRepository;
	@RequestMapping(value="/userSignup", method=RequestMethod.GET)
	 private String getSingupForm(Model model) {
		 return "signup";
	 }
	@RequestMapping(value="/userSignup", method=RequestMethod.POST)
	 private String SaveUser(@ModelAttribute User user, Model model) {
		
		UserRepository.save(user);
		model.addAttribute("username", new User());
		return "login";
	 }

}
