package com.georgievl.spring6restmvc.controllers;

import com.georgievl.spring6restmvc.model.Beer;
import com.georgievl.spring6restmvc.sercice.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    public String getBeerById(UUID id) {
        log.debug("Get beer by id was called in the controller.");
        return beerService.getBeerById(id).toString();
    }
}
