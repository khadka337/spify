package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ClzStudent;
import com.example.demo.repository.studentRepsitory;

@Controller
public class studentController {
	@Autowired
	private studentRepsitory StudentRepo;

	@GetMapping("/student")
	private String getStudentForm(Model model) {
		model.addAttribute("studentmodel", new ClzStudent());
		return "studentForm";
	}

	@PostMapping("/student")
	private String saveStudent(@ModelAttribute ClzStudent clzStudent) {
		StudentRepo.save(clzStudent);
		return "redirect:/student";
	}

	//Reading operation for student
	@GetMapping("/list")
	public String getAllStudents(Model model) {
		model.addAttribute("slist", StudentRepo.findAll());
		return "list";
	}

	//Delete operation for student
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int studentid) {
		StudentRepo.deleteById(studentid);
		return "redirect:/list";
	}
	@GetMapping("/edit/{id}")
	 public String edit(@PathVariable int id, Model model) {
		model.addAttribute("studentmodel",StudentRepo.getOne(id));
		return "editForm";
	 }
	@PostMapping("/update")
	public String update(@ModelAttribute ClzStudent clzStudent) {
		StudentRepo.save(clzStudent);
		return "redirect:/list";
	}
}
