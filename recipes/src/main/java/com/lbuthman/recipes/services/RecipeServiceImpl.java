package com.lbuthman.recipes.services;

import com.lbuthman.recipes.commands.RecipeCommand;
import com.lbuthman.recipes.converters.RecipeCommandToRecipe;
import com.lbuthman.recipes.converters.RecipeToRecipeCommand;
import com.lbuthman.recipes.domain.Recipe;
import com.lbuthman.recipes.repositories.RecipeRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRespository recipeRespository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRespository recipeRespository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRespository = recipeRespository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.debug("Getting Recipes from service.");
        List<Recipe> recipes = new ArrayList<>();
        recipeRespository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        log.debug("Getting Recipe by Id from service.");
        Optional<Recipe> recipeOptional = recipeRespository.findById(id);
        if (!recipeOptional.isPresent()) { throw new RuntimeException("Recipe with id " + id + " Not Found."); }

        return recipeOptional.get();
    }

    @Transactional
    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe recipeDetached = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe = recipeRespository.save(recipeDetached);
        log.debug("Saved Recipe with Id: " + savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
