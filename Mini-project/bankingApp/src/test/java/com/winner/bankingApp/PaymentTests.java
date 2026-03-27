package com.winner.bankingApp;

import com.winner.bankingApp.Service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


// To test the bean (to see the avalability of the bean)
@SpringBootTest
public class PaymentTests {
    @Autowired
    private PaymentService service;

    @Test
    void contextLoads(){
        assertNotNull(service);
    }
}
