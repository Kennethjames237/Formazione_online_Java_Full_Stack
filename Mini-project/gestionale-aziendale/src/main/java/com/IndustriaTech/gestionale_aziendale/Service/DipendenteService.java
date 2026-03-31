package com.IndustriaTech.gestionale_aziendale.Service;

import com.IndustriaTech.gestionale_aziendale.Entity.Dipendente;
import com.IndustriaTech.gestionale_aziendale.Entity.Reparto;
import com.IndustriaTech.gestionale_aziendale.Repository.DipendenteRepository;
import com.IndustriaTech.gestionale_aziendale.Repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.List;

@Service
public class DipendenteService {
    private final DipendenteRepository dipendenteRepository;
    private final RepartoRepository repartoRepository;

    @Autowired
    public DipendenteService(DipendenteRepository dipendenteRepository,RepartoRepository repartoRepository){
        this.dipendenteRepository = dipendenteRepository;
        this.repartoRepository = repartoRepository;
    }
    public List<Dipendente> getDipendenti(){
        return dipendenteRepository.findAll();
    }
    public Dipendente postDipendente(Dipendente dipendente){
        return dipendenteRepository.save(dipendente);
    }
    public void deleteDipendente(Long id){
        dipendenteRepository.deleteById(id);
    }
    public Dipendente updateDipendente(Long id, Dipendente dipendente){
    Dipendente existingDipendente =  dipendenteRepository.findById(id)
            .orElseThrow( ()-> new  RuntimeException ("Dipendente non trovato"));

         existingDipendente.setReparto(dipendente.getReparto());
         existingDipendente.setCognome(dipendente.getCognome());
         existingDipendente.setNome(dipendente.getNome());
         existingDipendente.setStipendio(dipendente.getStipendio());
         existingDipendente.setEmail(dipendente.getEmail());
         existingDipendente.setRuolo(dipendente.getRuolo());

         dipendenteRepository.save(existingDipendente);

         return existingDipendente;

    }
    public Dipendente getDepeneteById(Long id){
        return dipendenteRepository.findById(id)
                .orElseThrow( ()-> new RuntimeException("Dipendente non trovato"));
    }
    public Dipendente aggiornaStipendio(Long id, BigDecimal nuovaSomma){
        Dipendente existingDipendente = dipendenteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found"));
        if(nuovaSomma.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("il stipendio non può essere negativo");
        }
        existingDipendente.setStipendio(nuovaSomma);
        dipendenteRepository.save(existingDipendente);
        return existingDipendente;
    }
    public Dipendente trasferisciDipendente(Long idDipendente, Long idNuovoReparto){
        Dipendente existingDipendente = dipendenteRepository.findById(idDipendente)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        Reparto existingReparto = repartoRepository.findById(idNuovoReparto)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        existingDipendente.setReparto(existingReparto);
        return existingDipendente;
    }
}
