package com.example.Lezione21.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interfaccia che estende JpaRepository e fornisce l'accesso ai dati.
 *
 * Spring Data JPA genera automaticamente:
 *   - i metodi CRUD di base (findAll, save, deleteById, ecc.)
 *   - le query derivate da nomi di metodo (come findByCompleted)
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Query derivata: restituisce tutti i task filtrando per stato di completamento
    List<Task> findByCompleted(boolean completed);
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}
