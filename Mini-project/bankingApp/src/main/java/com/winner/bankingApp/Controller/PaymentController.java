package com.winner.bankingApp.Controller;

import com.winner.bankingApp.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service){
        this.service = service;
    }

    @GetMapping("/pay/{amount}")
    public String pay(@PathVariable double amount){
        this.service.makePayment(amount);
        return "Pagamento effettuato con successo";
    }

}
