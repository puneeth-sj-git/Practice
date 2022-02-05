package com.sjp.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjp.practice.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
