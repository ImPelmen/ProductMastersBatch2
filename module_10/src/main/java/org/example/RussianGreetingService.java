package org.example;

import org.springframework.stereotype.Component;

@Component
@RussianGreetingQualifier
public class RussianGreetingService implements GreetingService {
    @Override
    public void sayHello() {
        System.out.println("Привет мир!");
    }
}
