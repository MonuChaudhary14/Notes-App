package org.monu.notesapp.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString   
public class NotesDTO {

    private int id;
    private String name;
    private String title;
    private String description;
    private String emailId;

}
