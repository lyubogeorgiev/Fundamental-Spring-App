package com.georgievl.dependencyinjectiondemo.controllers;

import com.georgievl.dependencyinjectiondemo.services.GreetingService;
import com.georgievl.dependencyinjectiondemo.services.GreetingServiceImpl;

public class ConstructorInjectedController {
    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
