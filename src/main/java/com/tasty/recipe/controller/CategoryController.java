package com.tasty.recipe.controller;

import com.tasty.recipe.entity.Category;
import com.tasty.recipe.entity.City;
import com.tasty.recipe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/findCategory")
    public Category searchCategory(@RequestParam int id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            return categoryOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping("/findByName")
    public List<Category> findByName(@RequestParam String name) {
        List<Category> categoryList = categoryRepository.findByName(name);
        return categoryList;
    }

    @PostMapping("/add")
    public Category add(@RequestParam int id, @RequestParam String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return categoryRepository.save(category);
    }
}
