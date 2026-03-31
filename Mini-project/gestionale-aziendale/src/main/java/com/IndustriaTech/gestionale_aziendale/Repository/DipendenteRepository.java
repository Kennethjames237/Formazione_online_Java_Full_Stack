package com.IndustriaTech.gestionale_aziendale.Repository;

import com.IndustriaTech.gestionale_aziendale.Entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {
    List<Dipendente> findDipendenteByEmail (String email);
    List<Dipendente> findByRuolo (String ruolo);
    List<Dipendente> findDipendenteByStipendioGreaterThan(BigDecimal stipendio);
}
