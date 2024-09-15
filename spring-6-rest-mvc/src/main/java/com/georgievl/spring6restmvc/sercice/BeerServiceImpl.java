package com.georgievl.spring6restmvc.sercice;

import com.georgievl.spring6restmvc.model.Beer;
import com.georgievl.spring6restmvc.model.BeerStyle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Johnnys  IPA")
                .beerStyle(BeerStyle.IPA)
                .upc("12345")
                .price(new BigDecimal("6.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
