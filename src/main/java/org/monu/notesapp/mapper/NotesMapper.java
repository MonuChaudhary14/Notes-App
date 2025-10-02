package org.monu.notesapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monu.notesapp.DTO.NotesDTO;
import org.monu.notesapp.entity.NotesStructure;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotesMapper {

    @Mapping(source = "notes", target = "description")
    @Mapping(source = "email", target = "emailId")
    NotesDTO notesToNotesDTO(NotesStructure notes);

    List<NotesDTO> notesListToNotesDTOList(List<NotesStructure> notesList);

    @Mapping(source = "description", target = "notes")
    @Mapping(source = "emailId", target = "email")
    NotesStructure notesDTOToNotesStructure(NotesDTO notes);

}
