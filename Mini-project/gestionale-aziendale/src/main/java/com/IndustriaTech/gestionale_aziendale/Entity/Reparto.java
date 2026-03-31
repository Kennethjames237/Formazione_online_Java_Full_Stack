package com.IndustriaTech.gestionale_aziendale.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Reparto")
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String nome;

    @NotNull
    private String descrizione;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAssunzione;

    @Column(nullable = false)
    private LocalDateTime dataUltimoAggiornamento;

    @OneToMany(mappedBy = "reparto", cascade = CascadeType.ALL)
    private List<Dipendente> dipendenti = new ArrayList<>();

    public void addDipendente(Dipendente d){
        dipendenti.add(d); //add a dipendente in the list of THIS reparto
        d.setReparto(this); // set the reparto of the dipendente using THIS (that will add it to the Dipendente table Colume reparto_id)
    }

    protected Reparto(){

    }

    public Reparto(Long id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
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

    //getters and setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
