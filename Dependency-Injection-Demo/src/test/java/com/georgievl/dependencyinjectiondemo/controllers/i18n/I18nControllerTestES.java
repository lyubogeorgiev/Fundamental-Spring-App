package com.georgievl.dependencyinjectiondemo.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("ES")
@SpringBootTest
class I18nControllerTestES {
    @Autowired
    I18nController i18nController;

    @Test
    void sayHello() {
        i18nController.sayHello();
    }
}