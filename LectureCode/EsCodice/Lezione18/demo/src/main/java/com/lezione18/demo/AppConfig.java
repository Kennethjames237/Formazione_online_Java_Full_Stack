package com.lezione18.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe di configurazione annotata con @Configuration.
 *
 * Indica a Spring che questa classe contiene metodi che creano e configurano i bean.
 * Ogni metodo annotato con @Bean restituisce un oggetto che viene gestito
 * dal contenitore IoC di Spring.
 *
 * In altre parole: qui definiamo *come* vengono create le istanze usate dal programma.
 */
@Configuration
public class AppConfig {

    /**
     * Metodo @Bean che definisce come creare un oggetto PaymentProcessor.
     *
     * Spring chiama questo metodo una volta, memorizza il risultato
     * e lo rende disponibile come bean nel suo contesto.
     *
     * @return un'istanza concreta di PayPalProcessor
     */
    @Bean
    public PaymentProcessor paymentProcessor() {
        // Factory method → ritorna l'implementazione concreta dell'interfaccia
        return new PayPalProcessor();
    }

    /**
     * Metodo @Bean che definisce un PaymentService.
     *
     * Qui effettuiamo la "Dependency Injection manuale" all'interno della configurazione:
     * chiamiamo paymentProcessor() per ottenere il bean da iniettare nel costruttore
     * di PaymentService.
     *
     * Spring intercetta questa chiamata e garantisce che il bean restituito
     * sia quello già presente nel suo contesto, non una nuova istanza.
     *
     * @return un PaymentService con la dipendenza già iniettata
     */
    @Bean
    public PaymentService paymentService() {
        // Iniettiamo manualmente la dipendenza definita sopra
        return new PaymentService(paymentProcessor());
    }
}