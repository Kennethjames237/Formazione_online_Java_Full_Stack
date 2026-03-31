package com.example.Lezione19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale dell'applicazione Spring Boot.
 *
 * L'annotazione @SpringBootApplication:
 *    Avvia la configurazione automatica di Spring Boot
 *    Attiva la scansione dei componenti nel package corrente (e sottopacchetti)
 *    Crea e avvia il contesto IoC (ApplicationContext)
 *
 * In sintesi, questa classe è il punto di ingresso del programma.
 */
@SpringBootApplication
public class Lezione19Application {

	public static void main(String[] args) {
		// Avvia l'applicazione Spring Boot.
		// Crea il server integrato (Tomcat) e pubblica i controller REST.
		SpringApplication.run(Lezione19Application.class, args);
	}
}