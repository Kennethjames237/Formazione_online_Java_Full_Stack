package com.example.Lezione21.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementazione concreta dell’interfaccia TaskService.
 *
 * È annotata con @Service, quindi Spring la rileva come bean
 * e la inietta automaticamente dove serve.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    /**
     * Costruttore con iniezione automatica del repository.
     * Spring si occupa di fornire l’istanza di TaskRepository.
     */
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        // Usa il repository per salvare l'entità nel database
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        // Restituisce tutti i Task (SELECT * FROM tasks)
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getCompletedTasks() {
        // Restituisce solo i Task con completed = true
        return taskRepository.findByCompleted(true);
    }
}
