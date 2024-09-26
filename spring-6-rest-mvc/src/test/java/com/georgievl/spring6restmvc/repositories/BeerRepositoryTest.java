package com.georgievl.spring6restmvc.repositories;

import com.georgievl.spring6restmvc.bootstrap.BootstrapData;
import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.mappers.BeerMapperImpl;
import com.georgievl.spring6restmvc.mappers.CustomerMapperImpl;
import com.georgievl.spring6restmvc.model.BeerStyle;
import com.georgievl.spring6restmvc.services.BeerCsvServiceImpl;
import com.georgievl.spring6restmvc.services.BeerServiceImpl;
import com.georgievl.spring6restmvc.services.CustomerService;
import com.georgievl.spring6restmvc.services.CustomerServiceJPA;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class,
        BeerCsvServiceImpl.class,
        BeerMapperImpl.class,
        BeerServiceImpl.class,
        CustomerServiceJPA.class,
        CustomerMapperImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<Beer> beerList = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        System.out.println(beerList.getContent().size());

        assertThat(beerList.getContent().size()).isEqualTo(334);
    }

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
