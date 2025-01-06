package com.example.redisOptimization.repositories;

import com.example.redisOptimization.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, String> {
}
