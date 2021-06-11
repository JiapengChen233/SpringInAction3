package com.cjp.pizza.service;

import com.cjp.pizza.exception.PaymentException;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor {
    public PaymentProcessor() {
    }

    public void approveCreditCard(String creditCardNumber, String expMonth, String expYear, float amount) throws PaymentException {
        if (amount > 20.00) {
            throw new PaymentException();
        }
    }
}
