package com.jguenther.cookbook.Model;

import com.jguenther.cookbook.Model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private List<Ingredient> ingredients;
}
