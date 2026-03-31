package com.example.Lezione19;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST che espone gli endpoint HTTP per la gestione delle Task.
 *
 * Gestisce richieste GET, POST, PUT e DELETE su /api/tasks.
 * Riceve e restituisce dati in formato JSON grazie a Spring e Jackson.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    /**
     * Iniezione tramite costruttore: Spring crea automaticamente un TaskService
     * e lo fornisce a questo controller.
     */
    public TaskController(TaskService service) {
        this.service = service;
    }

    // ----------------------------------------------------------
    // GET /api/tasks
    // ----------------------------------------------------------
    /** Restituisce la lista di tutte le attività. */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> allTasks = service.getAll();
        return ResponseEntity.ok(allTasks);
    }

    // ----------------------------------------------------------
    // GET /api/tasks/{id}
    // ----------------------------------------------------------
    /** Restituisce una singola task per ID, oppure 404 se non trovata. */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ----------------------------------------------------------
    // POST /api/tasks
    // ----------------------------------------------------------
    /**
     * Crea una nuova attività.
     * Riceve un oggetto Task nel corpo della richiesta in formato JSON.
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
        Task created = service.create(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // ----------------------------------------------------------
    // PUT /api/tasks/{id}
    // ----------------------------------------------------------
    /**
     * Aggiorna un'attività esistente.
     * Restituisce 200 OK se aggiornata, 404 Not Found se l'ID non esiste.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task updatedTask) {
        return service.update(id, updatedTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ----------------------------------------------------------
    // DELETE /api/tasks/{id}
    // ----------------------------------------------------------
    /**
     * Elimina un'attività per ID.
     * Restituisce 204 No Content se eliminata, 404 Not Found se inesistente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        boolean removed = service.delete(id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
