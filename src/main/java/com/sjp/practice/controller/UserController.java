package com.sjp.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjp.practice.model.User;
import com.sjp.practice.service.UserService;
import com.sjp.practice.util.BusinessException;
import com.sjp.practice.util.ControllerException;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//URI Versioning
	@GetMapping(path="v1/getuser/{id}", produces = "application/json")
	public ResponseEntity<User> getUserV1(@PathVariable int id ){
		
		User u = userService.getUserById(id);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
		
	}
	
	@GetMapping("v2/getuser/{id}")
	public ResponseEntity<?> getUserV2(@PathVariable int id ){
		try {
	
		User u = userService.getUserById(id);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
		
		}catch(BusinessException e) {
			return new ResponseEntity<ControllerException>(new ControllerException(e.getErrCode(), e.getErrMsg()), HttpStatus.BAD_REQUEST);
		}
	}
}
