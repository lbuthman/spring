package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.RecipeCommand;
import com.lbuthman.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private CategoryToCategoryCommand categoryConverter;
    private IngredientToIngredientCommand ingredientConverter;
    private NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {

        if (recipe != null) {

            RecipeCommand recipeCommand = new RecipeCommand();
            recipeCommand.setId(recipe.getId());
            recipeCommand.setDescription(recipe.getDescription());
            recipeCommand.setPrepTime(recipe.getPrepTime());
            recipeCommand.setCookTime(recipe.getCookTime());
            recipeCommand.setServings(recipe.getServings());
            recipeCommand.setSource(recipe.getSource());
            recipeCommand.setUrl(recipe.getUrl());
            recipeCommand.setDirections(recipe.getDirections());
            recipeCommand.setNotes(notesConverter.convert(recipe.getNotes()));
            recipeCommand.setDifficulty(recipe.getDifficulty());

            if (recipe.getCategories() != null && recipe.getCategories().size() > 0) {
                recipe.getCategories().forEach(
                        category -> recipeCommand.getCategories().add(categoryConverter.convert(category)));
            }

            if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0) {
                recipe.getIngredients().forEach(
                        ingredient -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
            }

            return recipeCommand;
        }

        return null;
    }
}
