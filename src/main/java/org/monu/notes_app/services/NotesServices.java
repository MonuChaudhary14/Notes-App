    package org.monu.notes_app.services;

    import org.monu.notes_app.entity.NotesStructure;
    import org.monu.notes_app.repository.Data_Repo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class NotesServices {

        @Autowired
        private Data_Repo repo;

        public String home(){
            return "Notes App";
        }

        public List<NotesStructure> getAllNotes() {
            return repo.findAll();
        }

        public NotesStructure createNotes(NotesStructure notes) {
            return repo.save(notes);
        }

        public NotesStructure getNotesById(int id){
            return repo.findById(id).orElse(null);
        }

        public void deleteNotes(int id){
            repo.deleteById(id);
        }

        public NotesStructure updateNotes(int id , NotesStructure notes) {

            NotesStructure exist = repo.findById(id).orElse(null);
            if (exist == null) return null;

            if (notes.getName() != null) exist.setName(notes.getName());
            if (notes.getEmail() != null) exist.setEmail(notes.getEmail());
            if (notes.getNotes() != null) exist.setNotes(notes.getNotes());

            return repo.save(exist);

        }


    }
