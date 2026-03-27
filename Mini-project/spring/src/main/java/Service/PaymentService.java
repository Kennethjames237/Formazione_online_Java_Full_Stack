package Service;

import Interface.IPaymentProcessor;
import Logger.TransactionLogger;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    private final IPaymentProcessor paymentProcessor;
    private final TransactionLogger transactionLogger;

    @PostConstruct
    public void init(){
        System.out.println("PaymentService inizializzato..");
    }
    @Autowired
    public PaymentService(@Qualifier("creditCardProcessor") IPaymentProcessor paymentProcessor, TransactionLogger transactionLogger){
        this.paymentProcessor = paymentProcessor;
        this.transactionLogger = transactionLogger;
    }
    public void makePayment(double amount){
        paymentProcessor.processPayment(amount);
        transactionLogger.log("Register the amount of: " + amount + " EUR");
    }


}
