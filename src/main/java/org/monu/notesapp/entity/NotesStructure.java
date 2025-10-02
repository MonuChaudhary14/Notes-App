package org.monu.notesapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Entity class representing a note.
* Maps to the "notes" table in the database.
*/

@Getter @Setter
@ToString
@Entity
@Table(name = "notes")

public class NotesStructure {

    /**
    * Unique identifier for the note.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) @Getter(AccessLevel.NONE)
    private int id;

    /**
    * Name of the note creator.
    */
    @Column(nullable = false, length = 100)
    private String name;
    /**
    * Email of the note creator.
    */
    @Column(nullable = false, length = 100)
    private String email;

    /**
    * Content of the note.
    */
    @Column(length = 1000)
    private String notes;

    @Column(length = 100)
    private String title;

    /**
    * Timestamp when the note was created.
    * Cannot be updated after creation.
    */
    private LocalDateTime createdAt;

    /**
    * Timestamp when the note was last updated.
    */
    private LocalDateTime updatedAt;

    /**
    * Set creation and update timestamps before persisting.
    */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    /**
    * Update the timestamp before updating the note.
    */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
