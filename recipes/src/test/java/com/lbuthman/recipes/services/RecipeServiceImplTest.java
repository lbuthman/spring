package com.lbuthman.recipes.services;

import com.lbuthman.recipes.converters.RecipeCommandToRecipe;
import com.lbuthman.recipes.converters.RecipeToRecipeCommand;
import com.lbuthman.recipes.domain.Recipe;
import com.lbuthman.recipes.repositories.RecipeRespository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    private RecipeRespository recipeRespository;

    @Mock
    private RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRespository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(new Recipe());

        when(recipeRespository.findAll()).thenReturn(recipeData);
        List<Recipe> recipes = recipeService.getRecipes();

        assertEquals(1, recipes.size());
        verify(recipeRespository, times(1)).findAll();
    }

    @Test
    public void getRecipeById() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRespository.findById(1L)).thenReturn(recipeOptional);

        //when
        Recipe recipeReturned = recipeService.getRecipeById(1L);

        //then
        assertNotNull("Returned recipe is null.", recipeReturned);
        verify(recipeRespository, times(1)).findById(1L);
        verify(recipeRespository, never()).findAll();

    }
}