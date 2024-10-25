package com.example.recipebook.controller;

import com.example.recipebook.model.Recipe;
import com.example.recipebook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Get all recipes
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    // Display recipes in JSP
    @GetMapping("/list")  // Change this endpoint as needed
    public String showRecipeList(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipe"; // This should match your JSP file name without .jsp
    }
    // Get a recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Save a new recipe
    @PostMapping
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
    }

    // Delete a recipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Find recipes by cuisine
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<Recipe>> findByCuisine(@PathVariable String cuisine) {
        List<Recipe> recipes = recipeService.findByCuisine(cuisine);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    // Find recipes by meal type
    @GetMapping("/meal-type/{mealType}")
    public ResponseEntity<List<Recipe>> findByMealType(@PathVariable String mealType) {
        List<Recipe> recipes = recipeService.findByMealType(mealType);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
