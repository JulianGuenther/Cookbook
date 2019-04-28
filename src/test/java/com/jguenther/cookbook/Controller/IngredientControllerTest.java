package com.jguenther.cookbook.Controller;
import com.jguenther.cookbook.Ingredient;
import com.jguenther.cookbook.Repositories.IngredientRepository;
import com.jguenther.cookbook.Services.IngredientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class IngredientControllerTest {




    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IngredientService ingredientService;

    @MockBean
    private IngredientRepository ingredientRepository;


    @Before
    public void setUp() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Karotte");

        Mockito.when(ingredientRepository.findByName(ingredient.getName()))
                .thenReturn(ingredient);


    }

    @Test
    public void whenValidName_thenIngredientShouldBeFound() throws Exception {
        String name = "Karotte";
        Ingredient found = ingredientService.getIngredientByName(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }
}