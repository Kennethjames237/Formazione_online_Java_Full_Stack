package com.example.Lezione20;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interfaccia che estende JpaRepository.
 *
 * Spring Data JPA genera automaticamente l’implementazione a runtime.
 * Contiene già metodi CRUD standard (findAll, findById, save, deleteById...),
 * e possiamo definire query personalizzate scrivendo solo la firma del metodo.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Trova tutte le task con un certo stato di completamento (true/false)
    List<Task> findByCompleted(boolean completed);

    // Trova le task che contengono una parola nel titolo (case-insensitive)
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}
