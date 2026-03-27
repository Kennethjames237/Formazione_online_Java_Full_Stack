package Processor;

import Interface.IPaymentProcessor;

public class PaypalProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Elaborazione pagamento di " + amount + " EUR via PayPal.");
    }
}
