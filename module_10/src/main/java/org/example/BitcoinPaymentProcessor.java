package org.example;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@BitCoinQualifier
public class BitcoinPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплачиваю через Bitcoin: " + amount);
    }
}
