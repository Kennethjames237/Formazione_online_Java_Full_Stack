package com.lezione17;

/**
 * Classe "servizio" che utilizza un PaymentProcessor per effettuare pagamenti.
 *
 * NOTA IMPORTANTE:
 *  - PaymentService NON crea direttamente un'istanza di CreditCardProcessor.
 *  - Invece, riceve l'istanza "dall'esterno" (tramite costruttore).
 *
 * Questo è il principio dell'INVERSION OF CONTROL:
 *  la classe non controlla più la creazione delle proprie dipendenze.
 *  Qualcun altro (in questo caso, il main) inietterà la dipendenza necessaria.
 */
public class PaymentService {
    // Riferimento all'interfaccia, non all'implementazione concreta
    private final PaymentProcessor processor;
    /**
     * Costruttore con iniezione della dipendenza.
     *
     * Qui viene applicato il concetto di Dependency Injection:
     * il servizio non istanzia direttamente il processor,
     * ma lo riceve pronto e già configurato.
     *
     *  processor un'implementazione di PaymentProcessor (es. CreditCardProcessor)
     */
    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }
    /**
     * Metodo di business che utilizza la dipendenza iniettata.
     *
     * Non importa quale sia l'implementazione concreta del processor:
     * l'interfaccia garantisce che il metodo processPayment esista.
     *
     *  amount importo del pagamento
     */
    public void makePayment(double amount) {
        processor.processPayment(amount);
    }
}