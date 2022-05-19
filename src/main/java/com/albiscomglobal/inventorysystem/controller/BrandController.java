package com.albiscomglobal.inventorysystem.controller;


import com.albiscomglobal.inventorysystem.domain.Brand;
import com.albiscomglobal.inventorysystem.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping ("/brand")
    public String BrandeGoods(Model model) {

        model.addAttribute("branded" ,  brandService.getAllBrand());
        return  "Brand";
    }
}
