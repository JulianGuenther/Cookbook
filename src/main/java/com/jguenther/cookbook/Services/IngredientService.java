package com.jguenther.cookbook.Services;

import com.jguenther.cookbook.Model.Ingredient;
import com.jguenther.cookbook.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Ingredient ingredient) {
        this.ingredientRepository.delete(ingredient);
    }

    public Ingredient findIngredientById(long id) {
        Optional<Ingredient> ingr = this.ingredientRepository.findById(id);
        return ingr.orElse(null);
    }
}
