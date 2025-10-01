package org.monu.notesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class which calls the server.
 */
@SpringBootApplication
public class NotesAppApplication {

  /**
   *  This is the main function.
   *
   * @param args command-line arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(NotesAppApplication.class, args);
  }
}
