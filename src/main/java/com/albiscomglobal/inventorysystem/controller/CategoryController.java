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
    private  final CategoryRepository categoryRepository;

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

    public String saveCategory (@Valid @ModelAttribute("categories") Category categories,
                                BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            return "addcategory";
        }
        categoryService.saveCategory(categories);
        ra.addFlashAttribute("message" , "The category has been saved successfully");
        return "redirect:/category ";


    }


    @GetMapping("/deleteCategory/{id}")

    public String deleteCategory (@PathVariable(value= "id") Long id){
        this.categoryService.deleteCategory(id);
        return "redirect:/category";
    }


   /* @GetMapping(path = { "/update","/update/{id}"})

    public String updateCategory (@PathVariable("id") Long id, Category category,BindingResult result, Model model){
        category.setId(id);
        if(result.hasErrors()){
            category.setId(id);
            return "category";
        }
         categoryService.updateCategory(category);
        model.addAttribute("category", category);
        return "addcategory";
    }*/
  /*  @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
        model.addAttribute("category", category);
        return "addcategory";
    }
*/

    @GetMapping("/addnewcategory")
    public String showCreateaddNewCategory(Model model) {
        model.addAttribute("categories", new Category());
        return "addcategory";

    }

        @GetMapping("edit/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Category Id:" + id));
            model.addAttribute("category", category);
            return "update-category";
        }

        @PostMapping("update/{id}")
        public String updateStudent(@PathVariable("id") long id, @Valid Category category, BindingResult result,
                Model model) {
            if (result.hasErrors()) {
                category.setId(id);
                return "update-category";
            }

            categoryRepository.save(category);
            model.addAttribute("category", categoryRepository.findAll());
            return "redirect:/category";
        }

    }






