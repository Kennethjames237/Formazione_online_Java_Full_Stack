package com.kenny.ecommece_products.Controller;

import com.kenny.ecommece_products.Entity.Prodotto;
import com.kenny.ecommece_products.Repository.ProdottoRepository;
import com.kenny.ecommece_products.Service.ProdottoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prodotti")
public class prodottoController {
    private final ProdottoService service;

    public prodottoController(ProdottoService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Prodotto>> getProdotti(){
        List<Prodotto> products = service.getProduct();
        return ResponseEntity.ok(products);
    }
    @PostMapping
    public ResponseEntity<Prodotto> createProduct(@RequestBody Prodotto prodotto) {
        Prodotto savedProduct = service.createProduct(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }




}
