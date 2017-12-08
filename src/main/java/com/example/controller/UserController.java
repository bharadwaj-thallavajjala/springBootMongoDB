/*
 * Here I had annatated my controller class with repository class
 *  
 *  and created the crud operation methods completely
 * 
 * 
 * 
 * */

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	//create
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user){
		userRepository.save(user);
	}
	 
	//read
	@RequestMapping(value = "/{id}")
	public User read(@PathVariable String id){
		 return userRepository.findOneByName(id);
	}
	
	//update
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody User user){
		userRepository.save(user);
	}
	
	//delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		
		userRepository.deleteById(id);
	}
	
}
