package com.lbuthman.recipes.services;

import com.lbuthman.recipes.commands.RecipeCommand;
import com.lbuthman.recipes.domain.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();

    Recipe getRecipeById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
