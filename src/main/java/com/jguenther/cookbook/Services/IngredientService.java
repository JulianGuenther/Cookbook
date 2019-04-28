package com.jguenther.cookbook.Services;

import com.jguenther.cookbook.Ingredient;
import com.jguenther.cookbook.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void removeIngredient(Ingredient ingredient) {
        this.ingredientRepository.delete(ingredient);
    }

    public Ingredient getIngredientByName(String name) {
       return this.ingredientRepository.findByName(name);
    }
}
