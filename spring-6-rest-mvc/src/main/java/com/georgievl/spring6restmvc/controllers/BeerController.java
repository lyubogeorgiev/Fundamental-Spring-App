package com.georgievl.spring6restmvc.controllers;

import com.georgievl.spring6restmvc.sercice.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public String getBeerById(UUID id) {
        log.debug("Get beer by id was called in the controller.");
        return beerService.getBeerById(id).toString();
    }

}
