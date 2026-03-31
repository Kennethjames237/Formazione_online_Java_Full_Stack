package com.IndustriaTech.gestionale_aziendale.Controller;

import com.IndustriaTech.gestionale_aziendale.Entity.Reparto;
import com.IndustriaTech.gestionale_aziendale.Service.RepartoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reparti")
public class RepartoController {
    private final RepartoService service;

    @Autowired
    public RepartoController(RepartoService service){

        this.service = service;
    }
    @GetMapping
    public List<Reparto> getReparto(){

        return service.getReparto();
    }
    @PostMapping
    public Reparto postReparto(@RequestBody Reparto reparto){
        return service.postReparto(reparto);
    }
    @GetMapping("{id}")
    public Reparto getRepartoById(@PathVariable Long id){
        return service.getRepartoById(id);
    }
    @DeleteMapping("{id}")
    public void deleteRepartoById(@PathVariable Long id){
        service.deleteRepartoById(id);
    }
    @Transactional
    @PutMapping("{id}")
    public Reparto putReparto(@PathVariable Long id, @RequestBody Reparto reparto){
        return service.putReparto(id,reparto);
    }

}
