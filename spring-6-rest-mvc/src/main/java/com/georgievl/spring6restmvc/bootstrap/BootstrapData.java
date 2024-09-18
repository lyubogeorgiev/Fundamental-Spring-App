package com.georgievl.spring6restmvc.bootstrap;

import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.mappers.BeerMapper;
import com.georgievl.spring6restmvc.repositories.BeerRepository;
import com.georgievl.spring6restmvc.services.BeerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            BeerServiceImpl beerService = new BeerServiceImpl();

            List<Beer> beers = beerService.listBeers()
                    .stream()
                    .map(beerMapper::beerDtoToBeer)
                    .toList();

            beerRepository.saveAll(beers);
        }
    }
}
