package com.albiscomglobal.inventorysystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/Product")
    public String ProductControl(){


        return "Product";
    }
}
