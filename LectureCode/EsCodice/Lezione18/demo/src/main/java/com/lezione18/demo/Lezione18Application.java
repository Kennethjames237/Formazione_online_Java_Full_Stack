package com.lezione18.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Classe principale dell'applicazione Spring Boot.
 *
 * L'annotazione @SpringBootApplication racchiude tre annotazioni:
 *   - @Configuration → indica che la classe può contenere definizioni di bean.
 *   - @EnableAutoConfiguration → abilita la configurazione automatica di Spring Boot.
 *   - @ComponentScan → abilita la scansione dei componenti nel package.
 *
 * In questo esempio, tuttavia, NON usiamo l'autoconfigurazione completa di Spring Boot,
 * ma creiamo manualmente un contesto IoC basato su una classe di configurazione Java.
 */
@SpringBootApplication
public class Lezione18Application {

	public static void main(String[] args) {

		// 1️ Creazione manuale del contenitore IoC (Inversion of Control)
		//    Usiamo AnnotationConfigApplicationContext, passando la classe AppConfig
		//    che contiene la definizione dei bean.
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 2 Recuperiamo un bean dal contenitore IoC.
		//    Spring si occupa di creare e gestire il ciclo di vita dell'oggetto.
		//    Qui otteniamo un'istanza di PaymentService già configurata.
		PaymentService service = context.getBean(PaymentService.class);

		// 3️ Utilizziamo il servizio per effettuare un pagamento.
		//    La dipendenza (PaymentProcessor) è già stata iniettata da Spring.
		service.makePayment(100.0);

		// OUTPUT ATTESO:
		// Elaborazione pagamento di 100.0 EUR via PayPal.
	}
}