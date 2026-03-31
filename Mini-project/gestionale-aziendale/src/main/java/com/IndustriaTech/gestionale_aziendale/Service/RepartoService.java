package com.IndustriaTech.gestionale_aziendale.Service;

import com.IndustriaTech.gestionale_aziendale.Entity.Reparto;
import com.IndustriaTech.gestionale_aziendale.Repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartoService {

    private final RepartoRepository repartoRepository;

    @Autowired
    public RepartoService(RepartoRepository repartoRepository){
        this.repartoRepository = repartoRepository;
    }

    public List<Reparto> getReparto(){
        return repartoRepository.findAll();
    }

    public Reparto getRepartoById(Long id){
        return repartoRepository.getReferenceById(id);
    }

    public Reparto postReparto(Reparto reparto){
        return repartoRepository.save(reparto);
    }

    public void deleteRepartoById(Long id) {
        repartoRepository.deleteById(id);
    }

    public Reparto putReparto(Long id,Reparto reparto) {
        Reparto existingReparto = repartoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Non found"));

        existingReparto.setDescrizione(reparto.getDescrizione());
        existingReparto.setNome(reparto.getNome());
        repartoRepository.save(existingReparto);
        return existingReparto;
    }
}
