package com.georgievl.dependencyinjectiondemo.controllers;

import com.georgievl.dependencyinjectiondemo.services.GreetingService;
import com.georgievl.dependencyinjectiondemo.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }
    public String sayHello() {
        System.out.println("I'm in the controller!");

        return greetingService.sayGreeting();
    }
}
