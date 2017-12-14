package com.lbuthman.recipes.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe recipe;
    private Notes notes;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void setNotes() {
        notes = new Notes();
        recipe.setNotes(notes);
        assertEquals(notes, recipe.getNotes());
        assertEquals(recipe, notes.getRecipe());
    }

    @Test
    public void addIngredient() {
        ingredient = new Ingredient();
        recipe.addIngredient(ingredient);
        assertTrue(recipe.getIngredients().contains(ingredient));
        assertEquals(recipe, ingredient.getRecipe());
    }
}