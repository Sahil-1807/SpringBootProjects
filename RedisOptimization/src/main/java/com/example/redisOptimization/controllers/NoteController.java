package com.example.redisOptimization.controllers;

import com.example.redisOptimization.entities.Note;
import com.example.redisOptimization.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(note));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return ResponseEntity.ok(noteService.getAll());
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable String noteId){
        return ResponseEntity.ok(noteService.getById(noteId));
    }

    @DeleteMapping("/{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String noteId){
        noteService.delete(noteId);
    }
}
