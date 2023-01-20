package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.service.CategoryService;

@RestController
public class categoryController {
    

    @Autowired
    private CategoryService cService;

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){

        Category storedCategory = cService.addCategory(category);

        return new ResponseEntity<Category>(storedCategory, HttpStatus.ACCEPTED);
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException{
        
        Category updatedCategory = cService.updateCategory(category);

        return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id) throws CategoryException{
        
        Category deletedCategory = cService.deleteCategory(id);

        return new ResponseEntity<Category>(deletedCategory, HttpStatus.ACCEPTED);
    }

    @GetMapping("/category/all")
    public ResponseEntity<List<Category>> getAllCategory() throws CategoryException{

        List<Category> customer = cService.getAllCategory();

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @GetMapping("/category/total")
    public ResponseEntity<Double> getTotalCost() throws CategoryException{

        Double total = cService.getTotalCost();

        return new ResponseEntity<Double>(total, HttpStatus.OK);
    }



}
