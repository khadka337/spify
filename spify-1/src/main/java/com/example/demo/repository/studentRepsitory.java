package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ClzStudent;

public interface studentRepsitory extends JpaRepository<ClzStudent, Integer>{
	

}
