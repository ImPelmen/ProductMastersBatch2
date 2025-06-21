package org.example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class DependencyInjectorConfig {

    @Bean
    public PaymentProcessor paymentProcessor() {
        return new AllPaymentProcessor();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public GreetingService greetingProcessor() {
        return new AllGreetingService();
    }
}
