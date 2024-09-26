package com.georgievl.spring6restmvc.bootstrap;

import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.mappers.BeerMapper;
import com.georgievl.spring6restmvc.mappers.CustomerMapper;
import com.georgievl.spring6restmvc.model.BeerCSVRecord;
import com.georgievl.spring6restmvc.model.BeerStyle;
import com.georgievl.spring6restmvc.model.CustomerDTO;
import com.georgievl.spring6restmvc.repositories.BeerRepository;
import com.georgievl.spring6restmvc.repositories.CustomerRepository;
import com.georgievl.spring6restmvc.services.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    private final BeerService beerService;
    private final BeerCsvService beerCsvService;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        loadCsvData();
        addSampleCustomers();

//        if (beerRepository.count() == 0) {
//            BeerServiceImpl beerService = new BeerServiceImpl();
//
//            List<Beer> beers = beerService.listBeers()
//                    .stream()
//                    .map(beerMapper::beerDtoToBeer)
//                    .toList();
//
//            beerRepository.saveAll(beers);
//        }
    }

    private void addSampleCustomers() {
        if (customerRepository.count() < 2) {
            CustomerDTO customer1 = CustomerDTO.builder()
                    .name("John Smith")
                    .email("john.smith@gmail.com")
                    .build();

            CustomerDTO customer2 = CustomerDTO.builder()
                    .name("Jessica Adams")
                    .email("jess.adams@gmail.com")
                    .build();

            customerService.saveNewCustomer(customer1);
            customerService.saveNewCustomer(customer2);
        }
    }

    private void loadCsvData() throws FileNotFoundException {
        if (beerRepository.count() < 10) {
            File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");

            List<BeerCSVRecord> recs = beerCsvService.convertCSV(file);

            recs.forEach(beerCSVRecord -> {
                BeerStyle beerStyle = switch(beerCSVRecord.getStyle()) {
                    case "American Pale Lager" -> BeerStyle.LAGER;
                    case "American Pale Ale (APA)",
                         "American Black Ale",
                         "Belgian Dark Ale",
                         "American Blonde Ale",
                         "American Double / Imperial IPA",
                         "Saison / Farmhouse Ale" -> BeerStyle.IPA;
                    default -> BeerStyle.PILSNER;
                };

                beerRepository.save(Beer.builder()
                                .beerName(StringUtils.abbreviate(beerCSVRecord.getBeer(), 36))
                                .beerStyle(beerStyle)
                                .price(BigDecimal.TEN)
                                .upc(beerCSVRecord.getRow().toString())
                                .quantityOnHand(beerCSVRecord.getCount())
                        .build());
            });
        }
    }
}
