package com.lezione18.demo;

/**
 * Implementazione concreta dell'interfaccia PaymentProcessor.
 *
 * Questa classe simula un elaboratore di pagamenti via PayPal.
 * Viene istanziata da Spring come bean definito nel metodo @Bean di AppConfig.
 */
public class PayPalProcessor implements PaymentProcessor {

    /**
     * Implementazione del metodo definito nell'interfaccia.
     *
     * In un caso reale, qui ci sarebbero chiamate a un'API esterna PayPal,
     * autenticazione, controlli di sicurezza, ecc.
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Elaborazione pagamento di " + amount + " EUR via PayPal.");
    }
}