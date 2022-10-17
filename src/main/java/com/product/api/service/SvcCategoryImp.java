package com.product.api.service;

import com.product.api.entity.Category;
import com.product.api.respository.RepoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SvcCategoryImp implements SvcCategory{

    @Autowired
    RepoCategory repo;

    @Override
    public List<Category> getCategories() {
        return repo.findByStatus(1);
    }

    @Override
    public Category getCategory(Integer category_id) {
        return repo.findByCategoryId(category_id);
    }

    @Override
    public String createCategory(Category category) {
        // Hay que verificar si ya existe
        Category categorySaved = (Category) repo.findByCategory(category.getCategory());
        if(categorySaved != null){
            if(categorySaved.getStatus() == 0) {
                repo.activateCategory(categorySaved.getCatgory_id());
                return "Category has been activated";
            }
            else
                return "Category Already Exists";
        }
         repo.createCategory(category.getCategory());
         return "Category Created";
    }

    @Override
    public String updateCategory(Integer category_id, Category category) {
        // Hay que verificar si ya existe
        Category categorySaved = (Category) repo.findByCategoryId(category_id);
        if(categorySaved == null){
            return "Category does not exists";
        }
        if(categorySaved.getStatus() == 0) {
            return "Category does not exists";
        }
        categorySaved = (Category) repo.findByCategory(category.getCategory());
        if(categorySaved != null){
            return "Category already exists";
        }
        repo.updateCategory(category.getCategory(), category_id);
        return "Category Updated";
    }

    @Override
    public String deleteCategory(Integer category_id) {
        Category categorySaved = (Category) repo.findByCategoryId(category_id);
        if(categorySaved == null){
            return "Category does not exists";
        }
        repo.deleteByIdCategory(category_id);
        return "Category removed";
    }
}
