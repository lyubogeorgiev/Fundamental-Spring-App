package com.georgievl.spring6resttemplate.client;

import com.georgievl.spring6resttemplate.model.BeerDTO;
import com.georgievl.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void testDeleteBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("old beer name")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12340987")
                .build();

        BeerDTO beerDTO = beerClient.createBeer(newDto);

        beerClient.deleteBeer(beerDTO);

        System.out.println(beerDTO);

        assertThrows(HttpClientErrorException.class, () -> {
            beerClient.getBeerById(beerDTO.getId());
        });
    }


    @Test
    void testUpdateBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("old beer name")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12340987")
                .build();

        BeerDTO beerDTO = beerClient.createBeer(newDto);

        final String newName = "Updated Mango Bobs";
        beerDTO.setBeerName(newName);
        BeerDTO updatedBeer = beerClient.updateBeer(beerDTO);

        System.out.println(beerDTO);
        System.out.println(updatedBeer);
        assertEquals(newName, updatedBeer.getBeerName());

        System.out.println(updatedBeer.getBeerName());
    }

    @Test
    void testCreateBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12340987")
                .build();

        BeerDTO savedDTO = beerClient.createBeer(newDto);

        assertNotNull(savedDTO);
    }

    @Test
    void testGetBeerByID() {
        Page<BeerDTO> beerDTOS = beerClient.listBeers();

        BeerDTO beerDTO = beerDTOS.getContent().getFirst();

        BeerDTO beerById = beerClient.getBeerById(beerDTO.getId());

        assertNotNull(beerById);
    }

    @Test
    void listBeersNoBeerName() {

        beerClient.listBeers();
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", BeerStyle.IPA, true, 1, 25);
    }
}