package com.georgievl.dependencyinjectiondemo.services.i18n;

import com.georgievl.dependencyinjectiondemo.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"})
@Service("i18nService")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Greeting in English";
    }
}
