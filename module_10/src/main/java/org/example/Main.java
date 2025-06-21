package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Main {

    private final GreetingService greetingService;
    @Autowired
    @RussianGreetingQualifier
    public Main(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(DependencyInjectorConfig.class);

        Main main = context.getBean(Main.class);
        main.greetingService.sayHello();

        OrderService orderService = context.getBean(OrderService.class);
        orderService.makeOrder(BigDecimal.valueOf(15));

        OrderService orderServiceSecond = context.getBean(OrderService.class);
        orderServiceSecond.makeOrder(BigDecimal.valueOf(15));
    }
}