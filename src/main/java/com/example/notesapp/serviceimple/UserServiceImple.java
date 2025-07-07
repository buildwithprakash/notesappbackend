package com.example.notesapp.serviceimple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesapp.entity.User;
import com.example.notesapp.repository.UserRepository;
import com.example.notesapp.service.UserService;
@Service
public class UserServiceImple implements UserService{
 UserRepository userRepository;
 
 @Autowired
	public UserServiceImple(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}

	public UserServiceImple() {
	super();
	// TODO Auto-generated constructor stub
}

	@Override
	public User creatUser(User user) {
		// TODO Auto-generated method stub
		User user2=userRepository.save(user);
		return user2;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stu
		List<User> users =userRepository.findAll();
	return users;
	}

	@Override
	public User getUserName(String username) {
		// TODO Auto-generated method stub
		User user1=userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));
		return user1;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existingUser=userRepository.findByUsername(user.getUsername()).orElseThrow(()->new RuntimeException("User not found"));
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(long Id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(Id);
		
	}

}
