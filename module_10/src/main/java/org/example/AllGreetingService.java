package org.example;

public class AllGreetingService implements GreetingService{
    @Override
    public void sayHello() {
        System.out.println("Hello everyone");
    }
}
