package com.example.Lezione21.task;

import java.util.List;

/**
 * Interfaccia che definisce il contratto del servizio.
 *
 * Qui descriviamo solo *cosa* deve fare il servizio,
 * non *come* lo fa — l’implementazione è delegata a TaskServiceImpl.
 */
public interface TaskService {

    // Crea e salva un nuovo Task
    Task createTask(Task task);

    // Recupera tutti i Task dal database
    List<Task> getAllTasks();

    // Recupera solo i Task completati
    List<Task> getCompletedTasks();
}
