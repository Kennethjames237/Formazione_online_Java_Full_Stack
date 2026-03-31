package com.kenny.ecommece_products.Service;

import com.kenny.ecommece_products.Entity.Prodotto;
import com.kenny.ecommece_products.Repository.ProdottoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {
    private final ProdottoRepository repository;


    public ProdottoService(ProdottoRepository repository) {
        this.repository = repository;
    }

    public List<Prodotto> getProduct(){
        return repository.findAll();
    }

    public Prodotto createProduct(Prodotto prodotto) {
        return repository.save(prodotto);
    }

}
