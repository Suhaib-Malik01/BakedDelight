package com.masai.service;

import java.util.List;

import com.masai.exception.CategoryException;
import com.masai.model.Category;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category) throws CategoryException;

    public Category deleteCategory(Integer id) throws CategoryException;

    public List<Category> getAllCategory()throws CategoryException;

    public Double getTotalCost()throws CategoryException;
    
}
