package com.georgievl.spring6resttemplate.client;

import com.georgievl.spring6resttemplate.model.BeerDTO;
import com.georgievl.spring6resttemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

public interface BeerClient {
    Page<BeerDTO> listBeers(String beerName,
                            BeerStyle beerStyle,
                            Boolean showInventory,
                            Integer pageNumber,
                            Integer pageSize);

    Page<BeerDTO> listBeers();
}
