package org.monu.notesapp.services.interfaces;

import org.monu.notesapp.DTO.NotesDTO;
import org.monu.notesapp.entity.NotesStructure;

import java.util.List;

public interface ServicesInterface {

    String home();

    List<NotesDTO> getAllNotes();

    NotesDTO createNotes(NotesDTO notes);

    NotesDTO getNotesById(int id);

    void deleteNotes(int id);

    NotesDTO updateNotes(int id, NotesDTO notes);

}
