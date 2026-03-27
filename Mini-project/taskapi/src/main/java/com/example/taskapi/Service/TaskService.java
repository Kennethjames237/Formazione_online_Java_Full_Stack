package com.example.taskapi.Service;

import com.example.taskapi.Entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();


    public List<Task> findAll(){
        return tasks;
    }
    public ResponseEntity<Task> postTask(Task newTask){
        //log.info("Creazione nuovo task: {}", newTask.getTitle());
        //URI location = URI.create("/api/tasks " + newTask);

        //To avoid duplicate
        if (tasks.stream().anyMatch(t -> t.getTitle().equalsIgnoreCase(newTask.getTitle()))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Task già esistente");
        }

        if(newTask.getTitle() == null || newTask.getTitle().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Titolo obbligatorio");
        }
        newTask.setId(counter.incrementAndGet());
        this.tasks.add(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }
    public ResponseEntity<Task> getTaskById(long id){
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Void> deleteTask(long id){
        boolean removed = tasks.removeIf(task-> task.getId() == id);
        return removed ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
    public ResponseEntity<Task> updateTask(long id ,Task updatedTask){
        for(Task t : tasks){
            if(t.getId() == id){
                t.setTitle(updatedTask.getTitle());
                t.setCompleted(updatedTask.isCompleted());
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }
    public List<Task> getSortedTasks(){
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getTitle))
                .toList();
    }
    public List<Task> getTasksByCompletion( boolean completed){
        return tasks.stream()
                .filter(task -> task.isCompleted() == completed)
                .toList();
    }
    public Map<String, Object> getTaskCount(){
        return Map.of("total Tasks", tasks.size());
    }

}
