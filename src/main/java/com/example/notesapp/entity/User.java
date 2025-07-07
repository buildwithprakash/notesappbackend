package com.example.notesapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id 
private long userId;
private String name;
private String username;
private String password;

@OneToMany( mappedBy = "user" , cascade = CascadeType.ALL)
@JsonManagedReference
@JsonIgnore
private List<Notes> notes=new ArrayList<>();


public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(long userId, String name, String username, String password, List<Notes> notes) {
	super();
	this.userId = userId;
	this.name = name;
	this.username = username;
	this.password = password;
	this.notes = notes;
}

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Notes> getNotes() {
	return notes;
}

public void setNotes(List<Notes> notes) {
	this.notes = notes;
}



}
