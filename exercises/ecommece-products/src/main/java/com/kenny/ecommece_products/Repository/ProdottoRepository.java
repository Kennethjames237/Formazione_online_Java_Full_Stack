package com.kenny.ecommece_products.Repository;

import com.kenny.ecommece_products.Entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {
     List<Prodotto> findProdottoByNome (String nome);
     List<Prodotto> findByPrezzoLessThan(BigDecimal prezzo);
}
