package com.zb.lezione181;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Classe principale dell'applicazione Spring Boot.
 *
 * L'annotazione @SpringBootApplication fa tre cose fondamentali:
 * 1️ @Configuration → segnala che la classe può contenere metodi @Bean (definizioni di bean manuali)
 * 2️ @EnableAutoConfiguration → lascia che Spring Boot configuri automaticamente diversi componenti
 * 3️ @ComponentScan → abilita la scansione automatica dei componenti nel package corrente
 *
 * In breve: questa annotazione dice a Spring Boot di cercare automaticamente
 * tutte le classi annotate con @Component, @Service, @Repository, @Controller, ecc.
 * e di gestirle come bean nel suo contenitore IoC.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// Avvio dell'applicazione Spring Boot.
		// Questo metodo:
		//  - crea il contenitore IoC (ApplicationContext)
		//  - scansiona il package com.zb.lezione181
		//  - individua le classi annotate con @Component
		//  - le istanzia e collega automaticamente
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Definizione di un bean CommandLineRunner.
	 *
	 * CommandLineRunner è un'interfaccia di Spring Boot che permette di eseguire del codice
	 * immediatamente dopo l'avvio dell'applicazione (dopo che tutti i bean sono stati creati).
	 *
	 * Qui viene iniettato automaticamente un PaymentService (grazie a Spring)
	 * e usato per testare il flusso di pagamento all'avvio.
	 */
	@Bean
	CommandLineRunner run(PaymentService service) {
		// Il metodo ritorna una lambda che viene eseguita dopo il bootstrap di Spring.
		return args -> {
			// Chiama il metodo makePayment() del servizio iniettato.
			service.makePayment(250.0);
		};
	}
}