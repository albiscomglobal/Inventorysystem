package com.albiscomglobal.inventorysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PointController {

    @RequestMapping("/pointofsale")
    public String PoinControl(){


        return "pointofsale";
    }
}
