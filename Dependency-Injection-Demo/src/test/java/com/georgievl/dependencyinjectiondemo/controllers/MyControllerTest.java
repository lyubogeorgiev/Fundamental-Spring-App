package com.georgievl.dependencyinjectiondemo.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    @Test
    void sayHello() {
        MyController myController = new MyController();

        myController.sayHello();
    }
}