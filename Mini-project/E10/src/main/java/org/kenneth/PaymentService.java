package org.kenneth;

public class PaymentService {
    private IPaymentProcessor paymentProcessor;
    private TransactionLogger transactionLogger;

    public PaymentService(IPaymentProcessor paymentProcessor, TransactionLogger transactionLogger) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLogger = transactionLogger;
    }

    public void makePayment(double amount){
        paymentProcessor.processPayment(amount);
    }
}
