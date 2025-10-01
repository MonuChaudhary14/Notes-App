package org.monu.notesapp.services;

import java.util.List;
import org.monu.notesapp.entity.NotesStructure;
import org.monu.notesapp.repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling all note-related operations.
 */
@Service
public class NotesServices {

  /**
  * Repository for accessing note data from the database.
  */
  @Autowired
  private DataRepo repo;

  /**
  * Home service endpoint.
  */
  public String home() {
    return "Notes App";
  }

  /**
  * Retrieve all notes.
  *
  * @return List of all NotesStructure objects.
  */
  public List<NotesStructure> getAllNotes() {
    return repo.findAll();
  }

  /**
  * Create a new note.
  *
  * @return The created NotesStructure object.
  */
  public NotesStructure createNotes(NotesStructure notes) {
    return repo.save(notes);
  }

  /**
  * Retrieve a note by its ID.
  *
  * @param id ID of the note to retrieve.
  * @return NotesStructure object if found, otherwise null.
  */
  public NotesStructure getNotesById(int id) {
    return repo.findById(id).orElse(null);
  }

  /**
  * Delete a note by its ID.
  *
  * @param id ID of the note to delete.
  */
  public void deleteNotes(int id) {
    repo.deleteById(id);
  }

  /**
  * Update an existing note by its ID.
  *
  * @param id    ID of the note to update.
  * @param notes NotesStructure object containing updated data.
  * @return The updated NotesStructure object, or null if not found.
  */
  public NotesStructure updateNotes(int id, NotesStructure notes) {
    NotesStructure exist = repo.findById(id).orElse(null);
    if (exist == null) {
      return null;
    }

    if (notes.getName() != null) {
      exist.setName(notes.getName());
    }
    if (notes.getEmail() != null) {
      exist.setEmail(notes.getEmail());
    }
    if (notes.getNotes() != null) {
      exist.setNotes(notes.getNotes());
    }

    return repo.save(exist);
  }
}
