package org.example;

import org.springframework.stereotype.Component;

@Component
@EnglishGreetingQualifier
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
