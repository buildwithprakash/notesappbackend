package com.example.notesapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesapp.entity.User;
import com.example.notesapp.serviceimple.UserServiceImple;
import org.springframework.web.bind.annotation.GetMapping;



@RequestMapping("api/user")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
 UserServiceImple uServiceImple;
 
	public UserController() {
	super();
	// TODO Auto-generated constructor stub
}
	@Autowired
	public UserController(UserServiceImple uServiceImple) {
	super();
	this.uServiceImple = uServiceImple;
}
	@PostMapping("/register")
public	ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1=uServiceImple.creatUser(user);
		return new ResponseEntity<User>(user1, HttpStatus.CREATED);
	}
	@GetMapping("/register")
	ResponseEntity<List<User>> getUsers()
	{
		List<User> l1=uServiceImple.getAllUsers();
		return new ResponseEntity<List<User>>(l1,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	ResponseEntity<?> getUser(@RequestBody User user)
	{  try {
		User foundUser=uServiceImple.getUserName(user.getUsername());
		if(!foundUser.getPassword().equals(user.getPassword()))
				{
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
							.body(Map.of("message","Invalid username or password"));
				}
			return new ResponseEntity<User>(foundUser,HttpStatus.OK);
	} catch (RuntimeException e) {
		// TODO: handle exception
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(Map.of("message",e.getMessage()));
	}
		
	}
	
	
	
}
