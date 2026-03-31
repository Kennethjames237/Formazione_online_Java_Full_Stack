package com.zb.lezione181;

/**
 * Interfaccia che definisce un contratto comune per tutti i metodi di pagamento.
 *
 * L'uso di un'interfaccia consente di separare l'astrazione (cosa fa)
 * dall'implementazione (come lo fa).
 *
 * Questo approccio favorisce il principio di "programmare a un'interfaccia"
 * e rende possibile cambiare metodo di pagamento (es. PayPal, carta di credito)
 * senza modificare il resto del codice.
 */
public interface PaymentProcessor {

    /**
     * Metodo astratto che tutte le implementazioni dovranno definire.
     *
     * @param amount l'importo da processare.
     */
    void processPayment(double amount);
}