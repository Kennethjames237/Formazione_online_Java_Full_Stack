package com.winner.bankingApp.Interface;

import org.springframework.stereotype.Component;


public interface IPaymentProcessor {
    public void processPayment(double amount);
}
