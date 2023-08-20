package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface userRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String un, String psw);
	@Query(value="select* from user where username=:un and password=:psw", nativeQuery=true)
	User userLogin(@Param("un")String username,@Param("psw")String password);

}
