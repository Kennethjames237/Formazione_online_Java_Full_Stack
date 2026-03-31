package com.example.Lezione20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale dell'applicazione Spring Boot.
 *
 * @SpringBootApplication abilita:
 *  - la configurazione automatica,
 *  - la scansione dei componenti nel package com.example.Lezione20,
 *  - la creazione del contesto Spring e del DataSource configurato da JPA.
 */
@SpringBootApplication
public class Lezione20Application {

	public static void main(String[] args) {
		// Avvia l'applicazione Spring Boot.
		// Spring inizializza il contesto, crea i bean e avvia il server integrato.
		SpringApplication.run(Lezione20Application.class, args);
	}
}
