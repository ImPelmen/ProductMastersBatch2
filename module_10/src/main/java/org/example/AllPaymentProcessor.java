package org.example;

import java.math.BigDecimal;

public class AllPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплатил: " + amount);
    }
}
