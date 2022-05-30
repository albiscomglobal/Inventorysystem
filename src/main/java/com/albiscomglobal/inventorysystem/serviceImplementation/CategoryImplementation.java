package com.albiscomglobal.inventorysystem.serviceImplementation;

import com.albiscomglobal.inventorysystem.domain.Category;
import com.albiscomglobal.inventorysystem.exception.CategoryNotFoundException;
import com.albiscomglobal.inventorysystem.repository.CategoryRepository;
import com.albiscomglobal.inventorysystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> findAllCategory (String keyword) {

        if (keyword != null) {
            return categoryRepository.findAllCategory(keyword);

        }
        return categoryRepository.findAll();

    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category) ;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public Category updateCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> result = categoryRepository.findById(id);

        Category category= null;

        if (result.isPresent()) {
            category = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find category id - " + id);
        }

        return category;
    }

    /*@Override
    public Category findById(Long id) throws CategoryNotFoundException {
        //categoryRepository.findById(id);
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new CategoryNotFoundException("could not find the category with id" +id);*/
    }


