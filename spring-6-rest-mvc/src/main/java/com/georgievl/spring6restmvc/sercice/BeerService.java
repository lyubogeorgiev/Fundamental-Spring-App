package com.georgievl.spring6restmvc.sercice;

import com.georgievl.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);
}
