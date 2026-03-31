package com.lezione17;

/**
        * Interfaccia che definisce il "contratto" per qualsiasi elaboratore di pagamenti.
        *
        * L'idea principale è che il servizio (PaymentService) dipenderà da questa interfaccia,
        * e non da un'implementazione concreta.
        *
        * In questo modo, possiamo cambiare il modo in cui viene processato un pagamento
        * (ad esempio con carta di credito, PayPal, bonifico, ecc.)
        * senza modificare il codice del servizio stesso.
        */
public interface PaymentProcessor {
    void processPayment(double amount);
    /**
     * Metodo astratto che tutte le classi concrete dovranno implementare.
     *  amount importo del pagamento da elaborare
     */
}