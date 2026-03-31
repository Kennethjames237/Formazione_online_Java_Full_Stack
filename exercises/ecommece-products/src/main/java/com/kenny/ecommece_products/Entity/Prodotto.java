package com.kenny.ecommece_products.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prodotti")
public class Prodotto {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false, length = 50)
 private String nome;

 @Lob
 @Column(nullable = false)
 private String descrizione;

 @Column(nullable = false, precision = 10, scale = 2)
 private BigDecimal prezzo;

 @Column(nullable = false)
 private int quantitaDisponibile;

 @Column(name = "data_creazione", nullable = false)
 private LocalDateTime dataCreazione;

 @Column(name = "data_aggiornamento", nullable = false)
 private LocalDateTime dataAggiornamento;

 public Prodotto() {}

 public Prodotto(Long id, String nome, String descrizione, BigDecimal prezzo,
                 int quantitaDisponibile, LocalDateTime dataCreazione) {
  this.id = id;
  this.nome = nome;
  this.descrizione = descrizione;
  this.prezzo = prezzo;
  this.quantitaDisponibile = quantitaDisponibile;
  this.dataCreazione = dataCreazione;
 }

 @PrePersist
 protected void onCreate() {
  dataCreazione = LocalDateTime.now();
  dataAggiornamento = LocalDateTime.now();
 }

 @PreUpdate
 protected void onUpdate() {
  dataAggiornamento = LocalDateTime.now();
 }

 public Long getId() { return id; }

 public String getNome() { return nome; }
 public void setNome(String nome) { this.nome = nome; }

 public String getDescrizione() { return descrizione; }
 public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

 public BigDecimal getPrezzo() { return prezzo; }
 public void setPrezzo(BigDecimal prezzo) { this.prezzo = prezzo; }

 public int getQuantitaDisponibile() { return quantitaDisponibile; }
 public void setQuantitaDisponibile(int quantitaDisponibile) {
  this.quantitaDisponibile = quantitaDisponibile;
 }

 public LocalDateTime getDataCreazione() { return dataCreazione; }
 public LocalDateTime getDataAggiornamento() { return dataAggiornamento; }
}