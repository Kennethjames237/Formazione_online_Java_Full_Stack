package com.lezione17;

/**
 * Implementazione concreta dell'interfaccia PaymentProcessor.
 *
 * Questa classe rappresenta un "elaboratore" che gestisce pagamenti
 * tramite carta di credito.
 *
 * È una dipendenza che verrà iniettata nel servizio (PaymentService).
 */
public class CreditCardProcessor implements PaymentProcessor {
    /**
     * Implementazione specifica del metodo processPayment.
     * In un'applicazione reale, qui avremmo logiche per comunicare con
     * un gateway di pagamento, validare la carta, ecc.
     *
     *  amount importo del pagamento
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento con carta di credito: " + amount + " EUR");
    }
}