package com.IndustriaTech.gestionale_aziendale.Repository;

import com.IndustriaTech.gestionale_aziendale.Entity.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepartoRepository extends JpaRepository<Reparto, Long> {
    List<Reparto> findRepartoByNome (String nome);
    List<Reparto> findAllByOrderByNomeAsc();
}
