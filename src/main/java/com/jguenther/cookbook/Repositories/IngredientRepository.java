package com.jguenther.cookbook.Repositories;

import com.jguenther.cookbook.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Ingredient findByName(String name);
}
