package com.georgievl.spring6restmvc.repositories;

import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.entities.Category;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository repository;

    @Autowired
    BeerRepository beerRepository;

    Beer testBeer;
    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        testBeer = beerRepository.findAll().getFirst();
    }

    @Transactional
    @Test
    void testAddCategory() {
        Category savedCategory = categoryRepository.save(Category.builder()
                        .description("Ales")
                        .build());

        testBeer.addCategory(savedCategory);

        Beer savedBeer = beerRepository.save(testBeer);

        System.out.println(savedBeer.getBeerName());
    }
}