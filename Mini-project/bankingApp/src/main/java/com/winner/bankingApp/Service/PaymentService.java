package com.winner.bankingApp.Service;


import com.winner.bankingApp.Interface.IPaymentProcessor;
import com.winner.bankingApp.Logger.TransactionLogger;
import com.winner.bankingApp.Processor.CreditCardProcessor;
import com.winner.bankingApp.Processor.PaypalProcessor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    @Value("${application.name")
    private String appNAme;
    private final IPaymentProcessor paymentProcessor;
    private final TransactionLogger transactionLogger;

    @PostConstruct
    public void init(){
        System.out.println("PaymentService inizializzato..");
    }


    //creditCardProcessor paypalProcessor
    @Autowired
    public PaymentService(@Qualifier("creditCardProcessor") IPaymentProcessor paymentProcessor, TransactionLogger transactionLogger){
        this.paymentProcessor = paymentProcessor;
        this.transactionLogger = transactionLogger;
    }
    public void makePayment(double amount){
        System.out.println();
        System.out.println("---------------------------");
        paymentProcessor.processPayment(amount);
        transactionLogger.log("Register the amount of: " + amount + " EUR");
    }


}
