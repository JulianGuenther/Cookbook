package com.jguenther.cookbook.Controller;

import com.jguenther.cookbook.Cookbook;
import com.jguenther.cookbook.Model.Ingredient;
import com.jguenther.cookbook.Repositories.IngredientRepository;
import com.jguenther.cookbook.Services.IngredientService;
import com.jguenther.cookbook.Utils.JsonUtil;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Cookbook.class)
@AutoConfigureMockMvc
public class IngredientControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    private IngredientRepository ingredientRepository;

    @After
    public void resetDb() {
        ingredientRepository.deleteAll();
    }

    @Test
    public void whenValidInput_thenCreateIngredient() throws Exception {
        Ingredient karotte = new Ingredient();
        karotte.setName("Karotte");
        mvc.perform(post("/ingredient/create").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(karotte)));

        Ingredient found = ingredientRepository.findByName("Karotte");
        assertThat(found.getName()).isEqualTo("Karotte");
    }

    @Test
    public void whenIngredientExists_thenReturnIngredient() throws Exception {
        Ingredient tomate = new Ingredient();
        tomate.setName("Tomate");
        this.ingredientRepository.save(tomate);

        mvc.perform(get("/ingredient/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("name", is("Tomate")));

    }

    @Test public void whenValidInput_thenDeleteIngredient() throws Exception {
        Ingredient karotte = new Ingredient();
        karotte.setName("Karotte");

        this.ingredientRepository.save(karotte);

        mvc.perform(delete("/ingredient/delete").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(karotte)))
                .andExpect(status().isOk());


    }
}