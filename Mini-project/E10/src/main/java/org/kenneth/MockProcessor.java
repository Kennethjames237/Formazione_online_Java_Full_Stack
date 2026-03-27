package org.kenneth;

public class MockProcessor implements IPaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Simulazione pagamento");
    }
}
