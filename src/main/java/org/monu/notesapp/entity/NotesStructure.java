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

/**
* Entity class representing a note.
* Maps to the "notes" table in the database.
*/
@Entity
@Table(name = "notes")
public class NotesStructure {

    /**
    * Unique identifier for the note.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(updatable = false)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "NotesStructure{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", email='" + email + '\''
                + ", title='" + title + '\''
                + ", notes='" + notes + '\''
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + '}';

    }
}
