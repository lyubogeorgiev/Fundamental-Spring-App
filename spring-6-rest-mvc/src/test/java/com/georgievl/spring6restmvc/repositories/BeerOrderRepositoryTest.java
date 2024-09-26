package com.georgievl.spring6restmvc.repositories;

import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.entities.BeerOrder;
import com.georgievl.spring6restmvc.entities.BeerOrderShipment;
import com.georgievl.spring6restmvc.entities.Customer;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerOrderRepositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer testBeer;

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().getFirst();
        testBeer = beerRepository.findAll().getFirst();
    }

    @Transactional
    @Rollback
    @Test
    void testBeerOrders() {
        BeerOrder beerOrder = BeerOrder.builder()
                .customerRef("TestOrder")
                .customer(testCustomer)
                .beerOrderShipment(BeerOrderShipment.builder()
                        .trackingNumber("1234L")
                        .build())
                .build();

        BeerOrder savedBeerOrder = beerOrderRepository.save(beerOrder);

        System.out.println(savedBeerOrder.getCustomerRef());
    }
}