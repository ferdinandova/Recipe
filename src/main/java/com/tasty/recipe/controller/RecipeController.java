package com.tasty.recipe.controller;

import com.tasty.recipe.entity.Recipe;
import com.tasty.recipe.repository.RecipeRepository;
import com.tasty.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/getAllRecipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Recipe> list = recipeService.getAllRecipes(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public Recipe searchRecipe(@RequestParam int id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            return recipeOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping("/findByName")
    public List<Recipe> findByName(@RequestParam String name) {
        List<Recipe> recipeList = recipeRepository.findByName(name);
        return recipeList;
    }

    @PostMapping("/add")
    public Recipe add(@RequestParam int id, @RequestParam String name, @RequestParam BigDecimal price, @RequestParam int categoryId, @RequestParam String neededProducts, @RequestParam String instructions, @RequestParam int authorId, @RequestParam String timeForCooking) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setPrice(price);
        recipe.setCategoryId(categoryId);
        recipe.setNeededProducts(neededProducts);
        recipe.setInstructions(instructions);
        recipe.setAuthorId(authorId);
        recipe.setTimeForCooking(timeForCooking);

        return recipeRepository.save(recipe);
    }

    @PostMapping(
            value = "/createRecipe", consumes = "application/json", produces = "application/json")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        //add validation
        //use service
        return recipeRepository.save(recipe);
    }

}
