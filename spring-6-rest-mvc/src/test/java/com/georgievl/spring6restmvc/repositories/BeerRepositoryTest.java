package com.georgievl.spring6restmvc.repositories;

import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            beerRepository.save(Beer.builder()
                    .beerName("New saved beer too long of a name, i think already should be over 50 symbols or maybe not")
                    .beerStyle(BeerStyle.PILSNER)
                    .upc("1234567")
                    .price(new BigDecimal("8.76"))
                    .build());

            beerRepository.flush();

        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("New saved beer")
                        .beerStyle(BeerStyle.PILSNER)
                        .upc("1234567")
                        .price(new BigDecimal("8.76"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}
