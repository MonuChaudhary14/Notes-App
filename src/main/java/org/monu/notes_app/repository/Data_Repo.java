package org.monu.notes_app.repository;

import org.monu.notes_app.entity.Notes_Structure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Data_Repo extends JpaRepository<Notes_Structure, Integer> {

}
