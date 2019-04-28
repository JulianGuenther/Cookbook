package com.jguenther.cookbook;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter@Setter
public class Ingredient {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private List<Recipe> recipes;

}
