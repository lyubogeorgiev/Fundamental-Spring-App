package com.georgievl.dependencyinjectiondemo.controllers;

import com.georgievl.dependencyinjectiondemo.services.GreetingService;

public class PropertyInjectedController {
    GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
