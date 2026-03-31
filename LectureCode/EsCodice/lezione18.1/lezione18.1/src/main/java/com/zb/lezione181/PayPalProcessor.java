package com.zb.lezione181;

import org.springframework.stereotype.Component;

/**
 * Implementazione concreta dell'interfaccia PaymentProcessor.
 *
 * Annotata con @Component:
 *   → significa che Spring rileverà automaticamente questa classe
 *     durante la scansione dei componenti (grazie a @ComponentScan).
 *   → creerà un'istanza (bean) di PayPalProcessor all'interno del contenitore IoC.
 *
 * Quando Spring dovrà iniettare un PaymentProcessor,
 * troverà questa implementazione e la userà come dipendenza.
 */
@Component  // Spring creerà automaticamente un bean di questa classe
public class PayPalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // Logica di elaborazione del pagamento (simulata)
        System.out.println("Pagamento di " + amount + " EUR via PayPal (Spring Boot).");
    }
}