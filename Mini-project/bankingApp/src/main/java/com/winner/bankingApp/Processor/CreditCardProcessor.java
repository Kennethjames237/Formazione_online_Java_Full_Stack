package com.winner.bankingApp.Processor;
import com.winner.bankingApp.Interface.IPaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class CreditCardProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Addebito di " + amount + " EUR su carta di credito.");
    }
}
