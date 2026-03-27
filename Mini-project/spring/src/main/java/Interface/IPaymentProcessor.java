package Interface;

import org.springframework.stereotype.Component;

@Component
public interface IPaymentProcessor {
    public void processPayment(double amount);
}
