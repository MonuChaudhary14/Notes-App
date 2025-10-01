package org.monu.notesapp.services.interfaces;

import org.monu.notesapp.entity.NotesStructure;

import java.util.List;

public interface ServicesInterface {

    String home();

    List<NotesStructure> getAllNotes();

    NotesStructure createNotes(NotesStructure notes);

    NotesStructure getNotesById(int id);

    void deleteNotes(int id);

    NotesStructure updateNotes(int id, NotesStructure notes);

}
