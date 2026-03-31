package com.example.Lezione20;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Questa classe è un CONTROLLER REST.
 *
 * In un'applicazione Spring Boot, un controller riceve le richieste HTTP
 * provenienti da un client (ad esempio un frontend o Postman),
 * le elabora — eventualmente chiamando un "service" per la logica di business —
 * e restituisce una risposta HTTP (in formato JSON).
 */
@RestController
@RequestMapping("/api/tasks")  // Prefisso comune: tutte le rotte iniziano con /api/tasks
public class TaskController {

    // Il controller dipende da TaskService, che contiene la logica applicativa.
    // L'iniezione tramite costruttore è la modalità consigliata da Spring.
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * ---------------------------
     *  GET /api/tasks
     * ---------------------------
     * Questo metodo risponde a una richiesta HTTP GET.
     *
     * - Se il client chiama semplicemente /api/tasks → restituisce TUTTE le attività.
     * - Se chiama /api/tasks?completed=true → restituisce SOLO quelle completate.
     *
     * @RequestParam serve per leggere parametri della query string (es. ?completed=true).
     * @ResponseEntity permette di restituire sia i dati sia il codice di stato HTTP.
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) Boolean completed) {
        if (completed != null && completed) {
            // Se completed=true → restituisce solo le attività completate
            return ResponseEntity.ok(taskService.getCompletedTasks());
        }
        // Altrimenti restituisce tutte le attività
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    /**
     * ---------------------------
     *  POST /api/tasks
     * ---------------------------
     * Crea una nuova attività.
     *
     * Il client invia nel corpo (body) della richiesta un oggetto JSON, ad esempio:
     *     { "title": "Comprare il pane" }
     *
     * L'annotazione @RequestBody fa sì che Spring converta automaticamente
     * il JSON in un oggetto Java (Task).
     *
     * @ResponseEntity.status(201) indica che la risorsa è stata creata con successo.
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task.getTitle());
        return ResponseEntity.status(201).body(created); // 201 Created
    }

    /**
     * ---------------------------
     *  PUT /api/tasks/{id}
     * ---------------------------
     * Aggiorna un'attività esistente identificata dal suo "id".
     *
     * Esempio di chiamata:
     *     PUT /api/tasks/3
     *     Body JSON: { "title": "Comprare il latte", "completed": true }
     *
     * @PathVariable lega la variabile {id} del percorso URL al parametro del metodo.
     * @RequestBody permette di ricevere il nuovo contenuto dell'attività in JSON.
     *
     * Se l'id non esiste nel database → restituisce HTTP 404 (not found).
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask)
                .map(ResponseEntity::ok)                   // Restituisce 200 OK con il task aggiornato
                .orElse(ResponseEntity.notFound().build()); // Oppure 404 se non trovato
    }

    /**
     * ---------------------------
     *  DELETE /api/tasks/{id}
     * ---------------------------
     * Elimina un'attività esistente.
     *
     * Esempio di chiamata:
     *     DELETE /api/tasks/5
     *
     * Se l'attività esiste → viene cancellata e si restituisce 204 No Content.
     * Se non esiste → restituisce 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id)
                ? ResponseEntity.noContent().build()  // 204: eliminazione riuscita, nessun contenuto da restituire
                : ResponseEntity.notFound().build();  // 404: attività non trovata
    }
}
