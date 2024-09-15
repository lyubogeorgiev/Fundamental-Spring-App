package com.georgievl.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello from the Property Injected Service";
    }
}
