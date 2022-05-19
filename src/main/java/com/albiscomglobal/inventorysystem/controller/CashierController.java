package com.albiscomglobal.inventorysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CashierController {

    @RequestMapping("/cashier")
    public String CashierControl(){

        return "cashier";
    }
}
