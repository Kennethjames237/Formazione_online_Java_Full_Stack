package Processor;

import Interface.IPaymentProcessor;

public class CreditCardProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Addebito di " + amount + " EUR su carta di credito.");
    }
}
