package org.productcrudapp.controller;

import java.util.List;

import org.productcrudapp.model.Category;
import org.productcrudapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService catService;

    @PostMapping
    public String saveCategory(@RequestBody Category category) {
        boolean isAdded = catService.isAddCategory(category);
        return isAdded ? "Category added successfully." : "Failed to add category.";
    }

    @GetMapping
    public List<Category> getAllCategories(@RequestParam(value = "page", required = false) Integer page) {
        return catService.getAllCategory();
    }
    
    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Integer id) {
        Category category = catService.getCategoryById(id);
        return category != null ? category.toString() : "Category not found.";
    }
    
    @PutMapping("/{id}")
    public String updateCategory(@RequestBody Category category, @PathVariable("id") Integer id) {
        String result = catService.updateCategory(id, category);
        return result;
    }
    
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        String result = catService.deleteCategoryById(id);
        return result;
    }
}
