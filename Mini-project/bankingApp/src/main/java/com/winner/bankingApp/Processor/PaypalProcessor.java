package com.winner.bankingApp.Processor;
import com.winner.bankingApp.Interface.IPaymentProcessor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class PaypalProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Elaborazione pagamento di " + amount + " EUR via PayPal.");
    }
}
