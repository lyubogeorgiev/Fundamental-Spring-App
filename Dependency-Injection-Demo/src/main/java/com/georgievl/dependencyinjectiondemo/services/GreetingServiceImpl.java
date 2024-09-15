package com.georgievl.dependencyinjectiondemo.services;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello Everyone from the Base Service";
    }
}
