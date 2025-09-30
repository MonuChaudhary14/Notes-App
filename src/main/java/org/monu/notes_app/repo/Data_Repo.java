package org.monu.notes_app.repo;

import org.monu.notes_app.Entity.Notes_Structure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Data_Repo extends JpaRepository<Notes_Structure, Integer> {

}
