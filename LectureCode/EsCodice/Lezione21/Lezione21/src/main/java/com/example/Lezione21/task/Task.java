package com.example.Lezione21.task;

import jakarta.persistence.*;

/**
 * Classe Entity che rappresenta la tabella "tasks" nel database.
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Chiave primaria con incremento automatico
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private boolean completed = false;

    // Costruttore senza argomenti richiesto da JPA
    protected Task() {}

    // Costruttore per creare un nuovo Task da codice
    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

}
