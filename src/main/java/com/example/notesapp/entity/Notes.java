package com.example.notesapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notes {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String title;
private String content;
@ManyToOne
@JoinColumn(name="user_id")
@JsonBackReference
User user;
public Notes(long id, String title, String content, User user) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.user = user;
}
public Notes() {
	super();
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
