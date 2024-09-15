package com.georgievl.spring6restmvc.sercice;

import com.georgievl.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
