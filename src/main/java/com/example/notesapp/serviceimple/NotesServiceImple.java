package com.example.notesapp.serviceimple;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesapp.entity.Notes;
import com.example.notesapp.repository.NotesRepository;
import com.example.notesapp.service.NotesService;


@Service
public class NotesServiceImple implements NotesService {
NotesRepository notesRepository;


	public NotesServiceImple() {
	super();
	// TODO Auto-generated constructor stub
}
@Autowired
	public NotesServiceImple(NotesRepository notesRepository) {
	super();
	this.notesRepository = notesRepository;
}

	@Override
	public Notes createNotes(Notes notes) {
		// TODO Auto-generated method stub
		Notes n1=notesRepository.save(notes);
		return n1;
	}

	@Override
	public List<Notes> getAllNotes() {
		// TODO Auto-generated method stub
		List< Notes> notes=notesRepository.findAll();
		return notes;
	}

	@Override
	public List<Notes> getNotesByUserId(Long userId) {
		// TODO Auto-generated method stub
		List<Notes> notes=notesRepository.findByUser_UserId(userId);
		return notes;
	}

	@Override
	public Notes updateNotes(Long id, Notes updatednote) {
		// TODO Auto-generated method stub
		Notes n1=notesRepository.findById(id).orElseThrow(()->new RuntimeException("Note not found with id :"+id));
		n1.setTitle(updatednote.getTitle());
		n1.setContent(updatednote.getContent());
		
		return notesRepository.save(n1);
	}

	@Override
	public void deleteNotes(Long id) {
		// TODO Auto-generated method stub
		notesRepository.deleteById(id);
		
	}

	}
