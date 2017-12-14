package com.lbuthman.recipes.services;

import com.lbuthman.recipes.domain.Recipe;
import com.lbuthman.recipes.repositories.RecipeRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRespository recipeRespository;

    public RecipeServiceImpl(RecipeRespository recipeRespository) {
        this.recipeRespository = recipeRespository;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.debug("Getting recipes from service.");
        List<Recipe> recipes = new ArrayList<>();
        recipeRespository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
