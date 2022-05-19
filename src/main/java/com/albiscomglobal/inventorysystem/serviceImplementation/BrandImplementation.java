package com.albiscomglobal.inventorysystem.serviceImplementation;

import com.albiscomglobal.inventorysystem.domain.Brand;
import com.albiscomglobal.inventorysystem.repository.BrandRepository;
import com.albiscomglobal.inventorysystem.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandImplementation implements BrandService {

    @Autowired
    private BrandRepository brandRepository;



    @Override
    public List<Brand> getAllBrand() {
        return  brandRepository.findAll();
    }
}
