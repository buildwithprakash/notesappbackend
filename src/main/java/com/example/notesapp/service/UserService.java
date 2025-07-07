package com.example.notesapp.service;

import java.util.List;

import com.example.notesapp.entity.User;

public interface UserService {
	 User creatUser(User user);
	 List<User> getAllUsers();
	 User getUserName(String username);
	 User updateUser(User user);
	 void deleteUser(long Id);
	 
}
