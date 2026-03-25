package org.kenneth;

public class PayPalProcessor implements IPaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento di " + amount + "EUR tramite PayPal.");
    }
}
