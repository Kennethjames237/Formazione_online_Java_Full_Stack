package com.IndustriaTech.gestionale_aziendale.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Dipendente")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cognome;

    @Email
    @Column(nullable = false, length = 20,unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String ruolo;

    @Positive
    @Column(nullable = false, precision = 10 , scale = 2)
    private BigDecimal stipendio;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAssunzione;

    @Column(nullable = false)
    private LocalDateTime dataUltimoAggiornamento;

    //relationship between Dipendente e Reparto (1 dip -> 1 reparto)
    @ManyToOne
    @JoinColumn(name = "reparto_id") //foreign key
    private Reparto reparto;

    protected Dipendente(){
    }

    @PrePersist
    protected void onCreation(){
    this.dataAssunzione = LocalDateTime.now();
    this.dataUltimoAggiornamento = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.dataUltimoAggiornamento = LocalDateTime.now();
    }


    public Dipendente(Long id, String nome, String cognome, String email, String ruolo, BigDecimal stipendio,Reparto reparto) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.stipendio = stipendio;
        this.reparto =  reparto;
    }

    //getters and setters


    public Reparto getReparto() {
        return reparto;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public BigDecimal getStipendio() {
        return stipendio;
    }

    public void setStipendio(BigDecimal stipendio) {
        this.stipendio = stipendio;
    }
}
