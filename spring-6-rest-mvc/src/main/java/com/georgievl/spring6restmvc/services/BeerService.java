package com.georgievl.spring6restmvc.services;

import com.georgievl.spring6restmvc.model.BeerDTO;
import com.georgievl.spring6restmvc.model.BeerStyle;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Page<BeerDTO> listBeers(String beerName,
                            BeerStyle beerStyle,
                            Boolean showInventory,
                            Integer pageNumber,
                            Integer pageSize);

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteBeerById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}
