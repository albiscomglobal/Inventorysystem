package com.albiscomglobal.inventorysystem.repository;

import com.albiscomglobal.inventorysystem.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveCategory(){

        Category category = Category.builder()

                .category("Mobile")
                .status(1)
                .build();
        categoryRepository.save(category);



    }

}