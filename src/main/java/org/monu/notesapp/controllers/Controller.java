package org.monu.notesapp.controllers;

import java.util.List;
import org.monu.notesapp.entity.NotesStructure;
import org.monu.notesapp.services.NotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the controller class which handles the requests.
 */
@RestController
public class Controller {

  @Autowired
  private NotesServices notesServices;

  /**
  * This is the route for home page.
  */

  @GetMapping("/")
  public String home() {
    return notesServices.home();
  }

  /**
  * This is to get all the notes.
  */

  @GetMapping("/all")
  public List<NotesStructure> getAllNotes() {
    return notesServices.getAllNotes();
  }

  /**
  * This is used to create the notes.
  */

  @PostMapping("/create")
  public NotesStructure createNotes(@RequestBody NotesStructure notes) {
    return notesServices.createNotes(notes);
  }

  /**
  * This is used to find a specific note.
  */
  @GetMapping("/find/{id}")
  public NotesStructure getNotesById(@PathVariable("id") int id) {
    return notesServices.getNotesById(id);
  }

  /**
  * This is used to delete a note.
  */
  @DeleteMapping("/delete/{id}")
  public void deleteData(@PathVariable("id") int id) {
    notesServices.deleteNotes(id);
  }

  /**
  * This is used to update the notes.
  */

  @PutMapping("/update/{id}")
  public NotesStructure updateNotes(@PathVariable("id") int id, @RequestBody NotesStructure notes) {
    return notesServices.updateNotes(id, notes);
  }
}
