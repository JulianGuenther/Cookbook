package com.jguenther.cookbook.Controller;

import com.jguenther.cookbook.Ingredient;
import com.jguenther.cookbook.Services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    private IngredientService ingrService;

    @Autowired
    public IngredientController(IngredientService ingrService) {
        this.ingrService = ingrService;
    }

    @PostMapping("/ingredient/create")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return this.ingrService.saveIngredient(ingredient);
    }
}
