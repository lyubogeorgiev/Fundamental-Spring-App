package com.georgievl.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

@Service("setterGreetingBean")
public class GreetingServiceSetterInjection implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello from the Setter injected Greeting Service";
    }
}
