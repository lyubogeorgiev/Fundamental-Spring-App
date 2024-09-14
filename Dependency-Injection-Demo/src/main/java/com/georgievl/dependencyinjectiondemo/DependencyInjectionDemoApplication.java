package com.georgievl.dependencyinjectiondemo;

import com.georgievl.dependencyinjectiondemo.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DependencyInjectionDemoApplication.class, args);

        MyController myController = ctx.getBean(MyController.class);

        System.out.println("I am in main method");
        System.out.println(myController.sayHello());
    }
}
