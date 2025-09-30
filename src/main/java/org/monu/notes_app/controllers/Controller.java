package org.monu.notes_app.controllers;

import org.monu.notes_app.entity.NotesStructure;
import org.monu.notes_app.services.NotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

        @Autowired
        private NotesServices notesServices;

        @GetMapping("/")
        public String home() {
            return notesServices.home();
        }

        @GetMapping("/all")
        public List<NotesStructure> getAllNotes() {
            return notesServices.getAllNotes();
        }

        @PostMapping("/create")
        public NotesStructure createNotes(@RequestBody NotesStructure notes) {
            return notesServices.createNotes(notes);
        }

        @GetMapping("/find/{id}")
        public NotesStructure getNotesById(@PathVariable("id") int id) {
            return notesServices.getNotesById(id);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteData(@PathVariable("id") int id) {
            notesServices.deleteNotes(id);
        }

        @PutMapping("/update/{id}")
        public NotesStructure updateNotes(@PathVariable("id") int id, @RequestBody NotesStructure notes) {
            return notesServices.updateNotes(id ,notes);
    }

}
