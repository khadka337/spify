package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.users;

public interface UsersRepository extends CrudRepository<users, Long> {
 
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public users getUserByUsername(@Param("username") String username);

}
