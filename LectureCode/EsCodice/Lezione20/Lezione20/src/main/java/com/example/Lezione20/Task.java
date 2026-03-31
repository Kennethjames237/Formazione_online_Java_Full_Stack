package com.example.Lezione20;

import jakarta.persistence.*;

/**
 * Entità JPA che rappresenta la tabella "tasks" nel database.
 * Ogni istanza di questa classe corrisponde a una riga della tabella.
 */
@Entity
@Table(name = "tasks") // Nome esplicito della tabella
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // La chiave primaria è generata automaticamente dal DB (auto-increment)
    private Long id;

    @Column(nullable = false, length = 200)
    // Campo "title" obbligatorio, lunghezza massima 200 caratteri
    private String title;

    @Column(name = "is_completed")
    // Mappa il campo Java "completed" alla colonna "is_completed"
    private boolean completed;

    // Costruttore vuoto richiesto da JPA per creare le istanze tramite riflessione
    protected Task() {}

    // Costruttore di convenienza per creare nuove attività dal codice
    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    // Getter e Setter standard
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
