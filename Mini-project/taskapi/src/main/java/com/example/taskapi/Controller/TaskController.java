package com.example.taskapi.Controller;

import com.example.taskapi.Entity.Task;
import com.example.taskapi.Service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    @Autowired
    TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return this.service.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task newTask){
        return service.postTask(newTask);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id){
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id){
       return service.deleteTask(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id , @RequestBody Task updatedTask){
        return service.updateTask(id,updatedTask);
    }
    @GetMapping("/sorted")
    public List<Task> getSortedTasks(){
        return service.getSortedTasks();
    }
    @GetMapping(params = "completed")
    public List<Task> getTasksByCompletion(@RequestParam boolean completed){
        return service.getTasksByCompletion(completed);
    }
    @GetMapping("/count")
    public Map<String, Object> getTaskCount(){
        return service.getTaskCount();
    }
    @DeleteMapping
    public void clearAll(){
        service.findAll().clear();
    }


}
