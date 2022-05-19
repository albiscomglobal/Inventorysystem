package com.albiscomglobal.inventorysystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

    @RequestMapping("/report")
    public String ReportControl(){

        return "report";
    }
}
