package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ClzStudent;
import com.example.demo.repository.studentRepsitory;

@RestController
public class StudentRestAPI {
	@Autowired
	private studentRepsitory stdRepo;
	
	@GetMapping("/student/list")
	public List<ClzStudent> getAllStud() {
		return stdRepo.findAll();
	}
	@GetMapping("/student/{id}")
	public Optional<ClzStudent> getOneStud(@PathVariable int id) {
		return stdRepo.findById(id);
	}
	@PostMapping("/student/add")
	public String addStud(@RequestBody ClzStudent s) { 
		stdRepo.save(s);
		return "Success";
	}
	@GetMapping("/student/delete/{id}")
	public String deletStud(@PathVariable int id) {
		stdRepo.deleteById(id);
		return " delete Success";
	}
	@GetMapping("/student/j2o")
	public String jsonToObject() {
		RestTemplate retmp = new RestTemplate();
		ClzStudent s=retmp.getForObject("http://localhost:8080/student/2", ClzStudent.class);
		return "FName= "+s.getFname()+" city= "+s.getAddress().getCity();
		
	}
	@GetMapping("/student/json/list")
	public String jsonListToObjectList() {
		RestTemplate retmp = new RestTemplate();
		ClzStudent[] s=retmp.getForObject("http://localhost:8080/student/list", ClzStudent[].class);
		return "FName= "+s[0].getFname()+" city= "+s[0].getAddress().getCity();
		
	}
	

}
