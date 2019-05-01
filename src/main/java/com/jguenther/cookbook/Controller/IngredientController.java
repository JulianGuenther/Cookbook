package com.jguenther.cookbook.Controller;

import com.jguenther.cookbook.Model.Ingredient;
import com.jguenther.cookbook.Services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {

    private IngredientService ingrService;

    @Autowired
    public IngredientController(IngredientService ingrService) {
        this.ingrService = ingrService;
    }

    @GetMapping(value = "/ingredient/get/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("id") long id) {

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.ingrService.findIngredientById(id));
    }

    @PostMapping("/ingredient/create")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return this.ingrService.saveIngredient(ingredient);
    }

    @DeleteMapping("/ingredient/delete")
    public void deleteIngredient(@RequestBody Ingredient ingredient) {
        this.ingrService.deleteIngredient(ingredient);
    }
}
