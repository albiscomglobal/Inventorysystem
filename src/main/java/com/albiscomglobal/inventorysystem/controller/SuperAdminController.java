package com.albiscomglobal.inventorysystem.controller;


import com.albiscomglobal.inventorysystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperAdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/superadminpage")
    public String SystemSuperAdmin(Model model){

        model.addAttribute("countcat", categoryRepository.count());

        return "SuperAdminPage";
    }


}
