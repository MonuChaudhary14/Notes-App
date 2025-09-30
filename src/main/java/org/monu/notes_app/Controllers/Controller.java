package org.monu.notes_app.Controllers;

import org.monu.notes_app.Entity.Notes_Structure;
import org.monu.notes_app.repo.Data_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Data_Repo repo;

    @GetMapping("/all")
    public List<Notes_Structure> getAllNotes() {
        return repo.findAll();
    }

    @PostMapping("/create")
    public Notes_Structure createNotes(@RequestBody Notes_Structure notes) {
        return repo.save(notes);
    }

    @GetMapping("/id/{id}")
    public Notes_Structure getNotesById(@PathVariable("id") int id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/id/{id}")
    public void deleteData(@PathVariable("id") int id) {
        repo.deleteById(id);
    }

    @PutMapping("/id/{id}")
    public Notes_Structure updateNotes(@PathVariable int id, @RequestBody Notes_Structure notes) {
        Notes_Structure exist = repo.findById(id).orElse(null);
        if (exist == null) return null;

        if (notes.getName() != null) exist.setName(notes.getName());
        if (notes.getEmail() != null) exist.setEmail(notes.getEmail());
        if (notes.getNotes() != null) exist.setNotes(notes.getNotes());

        return repo.save(exist);
    }

}
