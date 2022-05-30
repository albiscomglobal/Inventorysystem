package com.albiscomglobal.inventorysystem.service;

import com.albiscomglobal.inventorysystem.domain.Category;
import com.albiscomglobal.inventorysystem.exception.CategoryNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    List<Category> getCategory ();


    //Pagination for Jpa
    Page <Category> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

   List<Category> findAllCategory(String keyword);

   Category saveCategory (Category category);

   void deleteCategory(Long id);

   Category updateCategory(Category category);

   //Category findById (Long id) throws CategoryNotFoundException;

    public Category findById(Long id);


}
