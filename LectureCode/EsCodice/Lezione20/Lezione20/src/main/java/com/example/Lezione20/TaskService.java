package com.example.Lezione20;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * ==============================================================
 *  CLASSE DI SERVIZIO (SERVICE LAYER)
 * ==============================================================
 * Questa classe contiene la logica applicativa dell'applicazione.
 *
 * Il controller si occupa solo di ricevere le richieste HTTP.
 * Il service invece gestisce "cosa fare" con i dati:
 *   - chiede al repository di leggere o scrivere sul database,
 *   - applica eventuali regole di business,
 *   - restituisce i risultati al controller.
 *
 * È annotata con @Service, che indica a Spring di gestirla
 * come un "bean" del contesto e abilita l’iniezione automatica.
 */
@Service
public class TaskService {

    //  Il repository è l’interfaccia che gestisce le operazioni CRUD sul database.
    private final TaskRepository taskRepository;

    // Iniezione del repository tramite costruttore (Dependency Injection)
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * ----------------------------------------------------------
     * getAllTasks()
     * ----------------------------------------------------------
     * Restituisce tutte le attività salvate nel database.
     *
     * Usa il metodo standard findAll() fornito da JpaRepository.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * ----------------------------------------------------------
     * createTask()
     * ----------------------------------------------------------
     * Crea e salva una nuova attività nel database.
     *
     * @param title titolo della nuova attività.
     * @return l'attività appena salvata, con ID assegnato da JPA.
     */
    public Task createTask(String title) {
        Task task = new Task(title);
        // save() salva l’entità nel database e restituisce quella persistita
        return taskRepository.save(task);
    }

    /**
     * ----------------------------------------------------------
     *  getCompletedTasks()
     * ----------------------------------------------------------
     * Restituisce tutte le attività completate (completed = true).
     */
    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    /**
     * ----------------------------------------------------------
     *  updateTask()
     * ----------------------------------------------------------
     * Aggiorna il titolo o lo stato "completed" di un’attività.
     *
     * @param id ID dell’attività da aggiornare.
     * @param updatedTask oggetto con i nuovi valori.
     * @return Optional contenente l’attività aggiornata, oppure vuoto se non trovata.
     *
     * Usa Optional per gestire in modo elegante il caso in cui l’ID non esista.
     */
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(existingTask -> {
            // Aggiorna i campi modificabili
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setCompleted(updatedTask.isCompleted());
            // Salva di nuovo nel database e restituisce l’entità aggiornata
            return taskRepository.save(existingTask);
        });
    }

    /**
     * ----------------------------------------------------------
     *  deleteTask()
     * ----------------------------------------------------------
     * Elimina un’attività dal database.
     *
     * @param id ID dell’attività da eliminare.
     * @return true se l’attività è stata eliminata, false se non esiste.
     */
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            // Se l’attività esiste, la cancella
            taskRepository.deleteById(id);
            return true;
        }
        // Se non esiste, restituisce false (usato per 404 nel controller)
        return false;
    }
}