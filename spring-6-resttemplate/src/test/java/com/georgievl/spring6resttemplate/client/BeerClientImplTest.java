package com.georgievl.spring6resttemplate.client;

import com.georgievl.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void listBeersNoBeerName() {

        beerClient.listBeers();
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", BeerStyle.IPA, true, 1, 25);
    }
}