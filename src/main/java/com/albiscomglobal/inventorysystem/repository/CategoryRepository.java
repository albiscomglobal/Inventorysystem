package com.albiscomglobal.inventorysystem.repository;

import com.albiscomglobal.inventorysystem.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

@Query("SELECT  c FROM Category c WHERE  c.category like %?1%")
    List<Category> findAllCategory (String keyword);

    //List<Category> findByCategory(String category);

    @Query(value = "SELECT COUNT(*) FROM category" , nativeQuery = true)
    List<Category> findByCategoryCount(String Category);


}
