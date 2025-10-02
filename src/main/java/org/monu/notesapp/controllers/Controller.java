package org.monu.notesapp.controllers;

import java.util.List;

import org.monu.notesapp.DTO.NotesDTO;
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
        List<NotesDTO> result = notesServiceInterface.getAllNotes();

        if (result == null || result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No notes found");
        }

        return ResponseEntity.ok(result);
    }

    /**
     * Create a new note.
     */
    @PostMapping("/create")
    public ResponseEntity<NotesDTO> createNotes(@RequestBody NotesDTO notes) {
        NotesDTO savedNote = notesServiceInterface.createNotes(notes);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }


    /**
     * Find a specific note by ID.
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getNotesById(@PathVariable("id") int id) {
        NotesDTO note = notesServiceInterface.getNotesById(id);

        if (note == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check your id");
        }

        return ResponseEntity.ok(note);
    }

    /**
     * Delete a note by ID.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") int id) {
        NotesDTO note = notesServiceInterface.getNotesById(id);

        if (note == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Note not found with id: " + id);
        }

        notesServiceInterface.deleteNotes(id);
        return ResponseEntity.ok("Note deleted successfully");
    }


    /**
     * Update an existing note by ID.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNotes(@PathVariable("id") int id, @RequestBody NotesDTO notes) {

        NotesDTO updated = notesServiceInterface.updateNotes(id, notes);

        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check whether the note exist");
        }

        return ResponseEntity.ok(updated);
    }
}
