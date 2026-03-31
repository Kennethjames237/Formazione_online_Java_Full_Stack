package com.lezione18.demo;

/**
 * Classe di servizio che utilizza un PaymentProcessor per eseguire pagamenti.
 *
 * Qui vediamo l'applicazione pratica dell'Inversion of Control:
 * - PaymentService NON crea da sé l'oggetto PayPalProcessor.
 * - Spring gli fornisce (inietta) automaticamente la dipendenza tramite AppConfig.
 */
public class PaymentService {

    // Riferimento a un oggetto che implementa PaymentProcessor
    private final PaymentProcessor processor;

    /**
     * Costruttore con Dependency Injection.
     *
     * Spring chiama questo costruttore e gli passa il bean corrispondente a PaymentProcessor.
     * Questo avviene in base alla configurazione definita nella classe AppConfig.
     *
     * @param processor implementazione concreta fornita da Spring (PayPalProcessor)
     */
    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    /**
     * Metodo di business che effettua un pagamento.
     * Il servizio delega il lavoro al processore iniettato.
     *
     * @param amount importo da pagare
     */
    public void makePayment(double amount) {

        this.processor.processPayment(amount);
    }
}