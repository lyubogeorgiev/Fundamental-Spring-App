package com.georgievl.spring6restmvc.controllers;

import com.georgievl.spring6restmvc.model.Beer;
import com.georgievl.spring6restmvc.sercice.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @RequestMapping(value = "/{beer_id}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beer_id") UUID beer_id) {
        log.debug("Get beer by id was called in the controller.");
        return beerService.getBeerById(beer_id);
    }
}
