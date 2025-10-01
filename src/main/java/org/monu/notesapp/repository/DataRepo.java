package org.monu.notesapp.repository;

import org.monu.notesapp.entity.NotesStructure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* This is an interface which extends the JpaRepository.
*/
public interface DataRepo extends JpaRepository<NotesStructure, Integer> {

}
