package com.georgievl.spring6restmvc.sercice;

import com.georgievl.spring6restmvc.model.Beer;
import com.georgievl.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beers;

    public BeerServiceImpl() {
        this.beers = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PILSNER)
                .upc("12356222")
                .price(new BigDecimal("10.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.PORTER)
                .upc("12356333")
                .price(new BigDecimal("7.99"))
                .quantityOnHand(34)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        this.beers.put(beer1.getId(), beer1);
        this.beers.put(beer2.getId(), beer2);
        this.beers.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBeers() {

        return new ArrayList<>(this.beers.values());
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by id in service was called. ");
        return this.beers.get(id);
    }
}
