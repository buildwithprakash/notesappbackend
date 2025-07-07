package com.example.notesapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesapp.entity.Notes;
import com.example.notesapp.serviceimple.NotesServiceImple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("api/notes")
@RestController
@CrossOrigin("*")
public class NotesController {
	
	NotesServiceImple notesServiceImple;

	public NotesController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public NotesController(NotesServiceImple notesServiceImple) {
		super();
		this.notesServiceImple = notesServiceImple;
	}
	@PostMapping("/addnotes")
	ResponseEntity<Notes> createNotes(@RequestBody Notes notes)
	{
		Notes n1=notesServiceImple.createNotes(notes);
		return new ResponseEntity<Notes>(n1, HttpStatus.CREATED);
	}
	
	@GetMapping("/getnotes/{userid}")
	ResponseEntity<List<Notes>> getNotesByUserId(@PathVariable Long userid){
		List<Notes> l1=notesServiceImple.getNotesByUserId(userid);
		return new ResponseEntity<List<Notes>>(l1,HttpStatus.OK);
	}
	
	@PutMapping("/updatenotes/{id}")
	ResponseEntity<Notes> updateNotes(@PathVariable long id,  @RequestBody Notes notes)
	{
		Notes updatenotes=notesServiceImple.updateNotes(id, notes);
		return new ResponseEntity<Notes>(updatenotes,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteNotes(@PathVariable long id)
	{
		notesServiceImple.deleteNotes(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
