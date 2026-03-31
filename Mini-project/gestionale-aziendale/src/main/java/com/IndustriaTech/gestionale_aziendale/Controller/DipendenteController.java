package com.IndustriaTech.gestionale_aziendale.Controller;

import com.IndustriaTech.gestionale_aziendale.Entity.Dipendente;
import com.IndustriaTech.gestionale_aziendale.Service.DipendenteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/dipendenti")
public class DipendenteController {

    private final DipendenteService service;

    @Autowired
    public DipendenteController(DipendenteService service){
        this.service = service;
    }

    @GetMapping
    public List<Dipendente> getDipendenti(){
        return service.getDipendenti();
    }
    @PostMapping
    public Dipendente postDipendente(@RequestBody Dipendente dipendente){
        return service.postDipendente(dipendente);
    }
    @DeleteMapping("{id}")
    public void deleteDipendente(@PathVariable  Long id){
        service.deleteDipendente(id);
    }

    @GetMapping("{id}")
    public Dipendente getDipendenteById(@PathVariable Long id){
        return service.getDepeneteById(id);
    }

    @Transactional
    @PutMapping("{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente){
        return service.updateDipendente(id,dipendente);
    }

    //update the salary of an employee
    @PatchMapping("{id}")
    public Dipendente aggiornaStipendio(@PathVariable Long id, @RequestParam BigDecimal nuovaSomma){
       return service.aggiornaStipendio(id,nuovaSomma);

    }

    //change the dipartment of an employee
    @Transactional
    @PatchMapping("/trasferisci")
    public Dipendente trasferisciDipendente(@RequestParam Long idDipendente, @RequestParam Long idNuovoReparto){
        return service.trasferisciDipendente(idDipendente,idNuovoReparto);
    }

}