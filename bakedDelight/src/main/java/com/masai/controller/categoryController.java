package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Category;
import com.masai.service.CategoryService;

@RestController
public class categoryController {
    

    @Autowired
    private CategoryService cService;

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(Category category){

        Category storedCategory = cService.addCategory(category);

        return new ResponseEntity<Category>(storedCategory, HttpStatus.ACCEPTED);
    }


}
