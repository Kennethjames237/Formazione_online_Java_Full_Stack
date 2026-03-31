package com.lezione17;

/**
 * Classe principale che avvia l'applicazione.
 *
 * Qui avviene l'inversione di controllo "manuale".
 *
 * In un'applicazione gestita da Spring, il framework si occuperebbe
 * di creare gli oggetti e collegarli (Dependency Injection automatica).
 *
 * In questo esempio, lo facciamo noi manualmente.
 */
public class DemoApplication {
	public static void main(String[] args) {

		// 1️ Creazione manuale dell'oggetto che implementa l'interfaccia PaymentProcessor.
		//    Qui scegliamo esplicitamente di usare la versione con carta di credito.
		PaymentProcessor processor = new CreditCardProcessor();

		// 2️ Iniezione della dipendenza nel servizio.
		//    PaymentService non sa né come né dove l'oggetto sia stato creato:
		//    riceve solo un riferimento pronto all'uso.
		PaymentService service = new PaymentService(processor);

		// 3️ Uso del servizio per eseguire un'operazione di business (fare un pagamento).
		//    L'implementazione concreta di PaymentProcessor verrà utilizzata automaticamente.

		service.makePayment(100.0);
		// OUTPUT ATTESO:
		// Pagamento con carta di credito: 100.0 EUR
	}
}
