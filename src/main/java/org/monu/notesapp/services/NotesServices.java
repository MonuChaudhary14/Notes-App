package org.monu.notesapp.services;

import java.util.List;

import org.monu.notesapp.DTO.NotesDTO;
import org.monu.notesapp.mapper.NotesMapper;
import org.monu.notesapp.entity.NotesStructure;
import org.monu.notesapp.repository.DataRepo;
import org.monu.notesapp.services.interfaces.ServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling all note-related operations.
 */
@Service
public class NotesServices implements ServicesInterface {

  /**
  * Repository for accessing note data from the database.
  */
    @Autowired
    private DataRepo repo;
    @Autowired
    private NotesMapper notesMapper;

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
    public List<NotesDTO> getAllNotes() {

        List<NotesStructure> notesList = repo.findAll();

        return notesMapper.notesListToNotesDTOList(notesList);
    }

    /**
    * Create a new note.
    */
    public NotesDTO createNotes(NotesDTO notes) {

        NotesStructure note = notesMapper.notesDTOToNotesStructure(notes);

        NotesStructure updatedNote = repo.save(note);

        return notesMapper.notesToNotesDTO(updatedNote);

    }

    /**
    * Retrieve a note by its ID.
    *
    * @param id ID of the note to retrieve.
    * @return NotesStructure object if found, otherwise null.
    */
    public NotesDTO getNotesById(int id) {

        NotesStructure notes = repo.findById(id).orElse(null);

        return notesMapper.notesToNotesDTO(notes);
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
    public NotesDTO updateNotes(int id, NotesDTO notes) {

        NotesStructure exist = repo.findById(id).orElse(null);
        if (exist == null) {
            return null;
        }

        if (notes.getName() != null) {
            exist.setName(notes.getName());
        }

        if (notes.getTitle() != null) {
            exist.setTitle(notes.getTitle());
        }
        if (notes.getDescription() != null) {
            exist.setNotes(notes.getDescription());
        }
        if (notes.getEmailId() != null) {
            exist.setEmail(notes.getEmailId());
        }

        NotesStructure updated = repo.save(exist);

        return notesMapper.notesToNotesDTO(updated);
    }

}
