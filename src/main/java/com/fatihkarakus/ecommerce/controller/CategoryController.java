package com.fatihkarakus.ecommerce.controller;

import com.fatihkarakus.ecommerce.common.ApiResponse;
import com.fatihkarakus.ecommerce.model.Category;
import com.fatihkarakus.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "Create a ne category"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategory() {
       return categoryService.listCategory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category)  {
        if(!categoryService.findById(categoryId)) {
            return new ResponseEntity<>(new ApiResponse(false, "Category does not exists"), HttpStatus.NOT_FOUND);
        }
        categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true, "Category has been updated"), HttpStatus.OK);
    }

}
