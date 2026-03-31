package com.lezione18.demo;
/**
 * Interfaccia che definisce il contratto per tutti i sistemi di pagamento.
 *
 * Il servizio dipende da questa interfaccia e NON da una classe concreta.
 * In questo modo, è possibile cambiare l'implementazione (es. PayPal, carta di credito, bonifico)
 * senza modificare il codice del servizio.
 *
 * Questo è un esempio di **programmazione ad interfacce**, un principio fondamentale
 * per l'Inversion of Control.
 */
public interface PaymentProcessor {

    /**
     * Metodo astratto per elaborare un pagamento.
     *
     * @param amount importo da elaborare
     */
    void processPayment(double amount);
}