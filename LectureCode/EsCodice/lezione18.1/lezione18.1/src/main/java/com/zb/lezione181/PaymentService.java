package com.zb.lezione181;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe di servizio che utilizza un PaymentProcessor per eseguire i pagamenti.
 *
 * Annotata con @Component:
 *   → Spring creerà un bean di tipo PaymentService e lo gestirà nel proprio contesto IoC.
 *   → Questo bean può poi essere iniettato in altre parti dell’applicazione (es. nel CommandLineRunner).
 */
@Component
public class PaymentService {

    // Riferimento alla dipendenza, definita solo come interfaccia.
    // Non sappiamo né creiamo l'implementazione concreta.
    private final PaymentProcessor processor;

    /**
     * Costruttore con iniezione automatica della dipendenza.
     *
     * L'annotazione @Autowired dice a Spring di cercare nel contesto un bean
     * compatibile con il tipo richiesto (PaymentProcessor).
     *
     * Poiché esiste un solo bean che implementa PaymentProcessor (PayPalProcessor),
     * Spring lo inietta automaticamente nel costruttore.
     *
     * Questo è il metodo raccomandato per la Dependency Injection in Spring,
     * perché:
     *   - garantisce l'immuabilità delle dipendenze (final)
     *   - rende i test più semplici
     *   - facilita la lettura e la manutenzione
     */
    @Autowired
    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    /**
     * Metodo di business che effettua un pagamento.
     *
     * Non conosce i dettagli dell'implementazione (PayPal, carta, ecc.),
     * ma chiama solo il metodo definito nell'interfaccia.
     *
     * Questo incarna il principio di "Inversion of Control":
     * la classe non gestisce le proprie dipendenze, ma le riceve dall'esterno (Spring).
     */
    public void makePayment(double amount) {
        this.processor.processPayment(amount);
    }
}