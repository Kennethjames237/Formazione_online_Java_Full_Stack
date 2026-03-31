package com.example.Lezione21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale dell’applicazione Spring Boot.
 *
 * @SpringBootApplication:
 *   - Avvia l’autoconfigurazione di Spring Boot
 *   - Attiva la scansione dei componenti nel package com.example.Lezione21
 *   - Crea automaticamente il contesto Spring (ApplicationContext)
 */
@SpringBootApplication
public class Lezione21Application {

	public static void main(String[] args) {
		// Avvia l’applicazione e il server web incorporato (Tomcat)
		SpringApplication.run(Lezione21Application.class, args);
	}
}
