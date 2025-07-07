package com.example.notesapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notesapp.entity.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
List<Notes> findByUser_UserId(Long userId);
}
