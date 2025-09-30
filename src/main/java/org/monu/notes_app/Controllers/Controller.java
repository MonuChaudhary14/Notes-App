package org.monu.notes_app.Controllers;

import org.monu.notes_app.Entity.Notes_Structure;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RequestMapping("/getNotes")
@RestController
public class Controller {

    private Map<String , Notes_Structure> structure_map = new HashMap<>();

    @GetMapping("/all")
    public List<Notes_Structure> getAllNotes(){
        return new ArrayList<>(structure_map.values());
    }

    @PostMapping("/create")
    public boolean createNotes(@RequestBody Notes_Structure notes) {

        structure_map.put(notes.getName() , notes);
        return true;
    }
    @GetMapping("/name/{myname}")
    public Notes_Structure getNotesByName(@PathVariable("myname") String name) {
        return structure_map.get(name);
    }

    @DeleteMapping("/name/{myname}")
    public Notes_Structure deleteData(@PathVariable("myname") String name) {
        return structure_map.remove(name);
    }

    @PutMapping("/name/{name}")
    public Notes_Structure updateNotes(@RequestBody Notes_Structure notes) {
        return structure_map.put(notes.getName() , notes);
    }



}
