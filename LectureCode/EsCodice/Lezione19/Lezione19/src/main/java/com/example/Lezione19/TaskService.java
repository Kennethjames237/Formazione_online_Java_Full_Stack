package com.example.Lezione19;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Classe di servizio che gestisce la logica applicativa delle Task.
 * Mantiene i dati in memoria e fornisce operazioni CRUD di base.
 */
@Service
public class TaskService {

    // Lista in memoria che contiene tutte le attività
    private final List<Task> tasks = new ArrayList<>();

    // Contatore che genera ID progressivi e univoci
    private final AtomicLong counter = new AtomicLong();

    /**
     * Eseguito automaticamente da Spring dopo l’inizializzazione del bean.
     * Vengono create alcune attività di esempio da visualizzare subito all’avvio.
     */
    @PostConstruct
    public void init() {
        tasks.add(new Task(counter.incrementAndGet(), "Studiare Spring Boot", false));
        tasks.add(new Task(counter.incrementAndGet(), "Creare API REST", true));
        tasks.add(new Task(counter.incrementAndGet(), "Testare il controller", false));
        System.out.println("TaskService inizializzato con dati di esempio.");
    }

    /**
     * Restituisce la lista completa di tutte le attività presenti.
     */
    public List<Task> getAll() {
        // Restituisce direttamente la lista delle task in memoria
        return tasks;
    }

    /**
     * Crea una nuova attività.
     * 1. Genera un nuovo ID.
     * 2. Lo assegna alla nuova task.
     * 3. Aggiunge la task alla lista.
     * 4. Restituisce la task creata.
     */
    public Task create(Task newTask) {
        newTask.setId(counter.incrementAndGet());
        tasks.add(newTask);
        System.out.println("Creata nuova task: " + newTask.getTitle());
        return newTask;
    }

    /**
     * Cerca una task in base al suo ID.
     * Se trovata, la restituisce dentro un Optional.
     * Se non trovata, restituisce un Optional vuoto.
     */
    public Optional<Task> findById(long id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    /**
     * Aggiorna una task esistente.
     * 1. Cerca la task tramite l’ID.
     * 2. Se trovata, aggiorna titolo e stato.
     * 3. Restituisce la task aggiornata.
     */
    public Optional<Task> update(long id, Task updatedTask) {
        return findById(id).map(existing -> {
            existing.setTitle(updatedTask.getTitle());
            existing.setCompleted(updatedTask.isCompleted());
            System.out.println("Aggiornata task con ID " + id);
            return existing;
        });
    }

    /**
     * Elimina una task in base all’ID.
     * 1. Cerca nella lista una task con l’ID indicato.
     * 2. Se trovata, la rimuove.
     * 3. Restituisce true se eliminata, false altrimenti.
     */
    public boolean delete(long id) {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed) {
            System.out.println("Eliminata task con ID " + id);
        }
        return removed;
    }
}
