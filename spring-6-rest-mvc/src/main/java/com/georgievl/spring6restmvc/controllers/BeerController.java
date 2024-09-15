package com.georgievl.spring6restmvc.controllers;

import com.georgievl.spring6restmvc.sercice.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

}
