package com.albiscomglobal.inventorysystem.controller;


import com.albiscomglobal.inventorysystem.domain.Category;
import com.albiscomglobal.inventorysystem.repository.CategoryRepository;
import com.albiscomglobal.inventorysystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller

public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/category")
    public String getCategory(Model model) {
        // model.addAttribute("categories", categoryService.getCategory() ); old
        //return "Categorys";

        return findPaginated(1, "category", "asc", model);
    }


    @GetMapping("/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 7;
        Page<Category> page = categoryService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Category> categories = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortField", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("categories", categories);
        return "Categorys";

    }

    @GetMapping("/search")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Category> findAllCategory = categoryService.findAllCategory(keyword);
        model.addAttribute("categories", findAllCategory);
        model.addAttribute("keyword", keyword);
        return "categorys";
    }


    @PostMapping("/addcategory")

    public String saveCategory(@Valid @ModelAttribute("categories") Category categories,
                               BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            return "addcategory";
        }
        categoryService.saveCategory(categories);
        ra.addFlashAttribute("message", "The category has been saved successfully");
        return "redirect:/category ";


    }


    @GetMapping("/deleteCategory/{id}")

    public String deleteCategory(@PathVariable(value = "id") Long id) {
        this.categoryService.deleteCategory(id);
        return "redirect:/category";
    }


   

    @GetMapping("/addnewcategory")
    public String showCreateaddNewCategory(Model model) {
        model.addAttribute("categories", new Category());
        return "addcategory";

    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,
                                    Model theModel) {

        // get the employee from the service
        Category category = categoryService.findById((long) id);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("categories", category);

        // send over to our form
        return "addcategory";
    }


}



