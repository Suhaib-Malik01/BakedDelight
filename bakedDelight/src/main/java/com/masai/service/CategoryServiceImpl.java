package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository cDao;

    @Override
    public Category addCategory(Category category) {
        
        
        return cDao.save(category);
    }

    @Override
    public Category updateCategory(Category category) throws CategoryException {
       
        cDao.findById(category.getCategoryId()).orElseThrow(()-> new CategoryException("Category Not found..."));
        

        return cDao.save(category);
    }

    @Override
    public Category deleteCategory(Integer id) throws CategoryException {
        

        Category category = cDao.findById(id).orElseThrow(()-> new CategoryException("Category Not Found..."));

        cDao.delete(category);


        return category;
    }

    @Override
    public List<Category> getAllCategory() throws CategoryException {
        

        List<Category> categories = cDao.findAll();

        if(categories.size()==0) throw new CategoryException("Categories Not Found...");

        return categories;
    }

    @Override
    public Double getTotalCost() throws CategoryException {
        
        double Total = 0;

        List<Category> categories = cDao.findAll();

        if(categories.size()==0) throw new CategoryException("Categories Not Found...");

        for(Category ele: categories){
            List<Product> productList = ele.getProducts();

            for(Product product: productList){

                Total += product.getPrice();
            }

        }
        return Total;
    }
    
}
