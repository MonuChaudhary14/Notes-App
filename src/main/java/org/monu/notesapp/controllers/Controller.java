package org.monu.notesapp.controllers;

import java.util.List;
import org.monu.notesapp.entity.NotesStructure;
import org.monu.notesapp.services.interfaces.ServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class which handles all note-related API requests.
 */
@RestController
public class Controller {

    @Autowired
    private ServicesInterface notesServiceInterface;


    /**
     * Home endpoint.
     */
    @GetMapping("/")
    public ResponseEntity<String> home() {
        String homepage = notesServiceInterface.home();
        return ResponseEntity.ok(homepage);
    }

    /**
     * Get all notes.
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllNotes() {
        List<NotesStructure> result = notesServiceInterface.getAllNotes();

        if (result == null || result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(result);
    }

    /**
     * Create a new note.
     */
    @PostMapping("/create")
    public ResponseEntity<NotesStructure> createNotes(@RequestBody NotesStructure notes) {
        NotesStructure savedNote = notesServiceInterface.createNotes(notes);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }


    /**
     * Find a specific note by ID.
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<NotesStructure> getNotesById(@PathVariable("id") int id) {
        NotesStructure note = notesServiceInterface.getNotesById(id);

        if (note == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(note);
    }

    /**
     * Delete a note by ID.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") int id) {
        NotesStructure note = notesServiceInterface.getNotesById(id);

        if (note == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        notesServiceInterface.deleteNotes(id);
        return ResponseEntity.ok("Files Deleted Successfully");
    }

    /**
     * Update an existing note by ID.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<NotesStructure> updateNotes(@PathVariable("id") int id, @RequestBody NotesStructure notes) {

        NotesStructure updated = notesServiceInterface.updateNotes(id, notes);

        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(updated);
    }
}
