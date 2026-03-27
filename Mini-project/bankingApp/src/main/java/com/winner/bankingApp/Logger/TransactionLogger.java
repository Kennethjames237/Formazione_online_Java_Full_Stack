package com.winner.bankingApp.Logger;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {
    public void log(String msg){
        System.out.println("[LOG] " + msg);
    }
}
