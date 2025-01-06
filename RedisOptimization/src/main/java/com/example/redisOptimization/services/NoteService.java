package com.example.redisOptimization.services;

import com.example.redisOptimization.entities.Note;
import com.example.redisOptimization.repositories.NoteRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
    private NoteRepo repo; // constructore injection

    public NoteService(NoteRepo noteRepo){
        this.repo = noteRepo;
    }

    @CachePut(value = "notes", key = "#note.id")
    public Note createNote(Note note){
        note.setId(UUID.randomUUID().toString());
        return repo.save(note);
    }

    public List<Note> getAll(){
        return repo.findAll();
    }

    @Cacheable(value = "notes", key = "#noteId")
    public Note getById(String noteId){
        return repo.findById(noteId).orElseThrow(() -> new RuntimeException("note with this id is not found."));
    }

    public Note updateNote(String noteId, Note note){
        Note currentNote = repo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with this id is not found"));
        currentNote.setContent(note.getContent());
        currentNote.setTitle(note.getTitle());
        currentNote.setAddedDate(note.getAddedDate());

        return repo.save(note);
    }

    @CacheEvict(value = "notes", key = "#noteId")
    public void delete(String noteId){
        Note currentNote = repo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with this id is not found"));
        repo.delete(currentNote);
    }
}
