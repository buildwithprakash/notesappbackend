package com.example.notesapp.service;

import java.util.List;

import com.example.notesapp.entity.Notes;



public interface NotesService {

 Notes createNotes(Notes notes);
 List<Notes>  getAllNotes();
 List<Notes> getNotesByUserId(Long userId);
 Notes updateNotes(Long id, Notes updatednote);
 void deleteNotes(Long id);
}
