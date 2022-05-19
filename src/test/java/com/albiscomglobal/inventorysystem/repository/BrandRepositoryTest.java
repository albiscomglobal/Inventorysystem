package com.albiscomglobal.inventorysystem.repository;

import com.albiscomglobal.inventorysystem.domain.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class BrandRepositoryTest {


    @Autowired
    private BrandRepository brandRepository;

    @Test
    public void  BrandTest(){

        Brand brand  = Brand.builder()

                .brand("Nokia")
                .status(2)

                .build();


        brandRepository.save(brand);


    }

}