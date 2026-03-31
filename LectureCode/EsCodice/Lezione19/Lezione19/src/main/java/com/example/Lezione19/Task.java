package com.example.Lezione19;

/**
 * Classe POJO che rappresenta un'entità di dominio: una "Task" (attività).
 *
 * Ogni Task ha tre proprietà:
 *   - id: identificativo univoco
 *   - title: titolo o descrizione breve
 *   - completed: stato booleano (true = completata)
 *
 * Questa classe funge da "modello" per i dati scambiati tra client e server.
 * Spring Boot, grazie a Jackson, converte automaticamente oggetti Task in JSON e viceversa.
 */
public class Task {

    // Campo identificativo
    private long id;

    // Titolo o descrizione dell'attività
    private String title;

    // Stato di completamento
    private boolean completed;

    /**
     * Costruttore vuoto richiesto da Jackson per la deserializzazione JSON.
     *
     * Quando un client invia un JSON a Spring (ad esempio via POST),
     * il framework usa questo costruttore per creare un oggetto Task e poi
     * popolare i campi con i dati ricevuti.
     */
    public Task() {}

    /**
     * Costruttore completo, utile per creare manualmente nuove Task.
     */
    public Task(long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // --- Getter e Setter ---
    // Servono per permettere a Jackson di leggere e scrivere i campi della classe.

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
