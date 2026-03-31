package com.example.Lezione21.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller REST che espone le API HTTP.
 * Comunica con TaskService senza conoscere l’implementazione concreta.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    /**
     * Iniezione del servizio tramite costruttore.
     * Spring fornirà automaticamente l’istanza di TaskServiceImpl.
     */
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /api/tasks → restituisce tutte le attività
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /api/tasks/completed → restituisce solo le attività completate
    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return taskService.getCompletedTasks();
    }

    // POST /api/tasks → crea una nuova attività
    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        return taskService.createTask(newTask);
    }
}
