package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.RecipeCommand;
import com.lbuthman.recipes.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private CategoryCommandToCategory categoryConverter;
    private NotesCommandToNotes notesConverter;
    private IngredientCommandToIngredient ingredientConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, NotesCommandToNotes notesConverter, IngredientCommandToIngredient ingredientConverter) {
        this.categoryConverter = categoryConverter;
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
    }

    @Override
    public Recipe convert(RecipeCommand recipeCommand) {

        if (recipeCommand != null) {

            Recipe recipe = new Recipe();
            recipe.setId(recipeCommand.getId());
            recipe.setDescription(recipeCommand.getDescription());
            recipe.setPrepTime(recipeCommand.getPrepTime());
            recipe.setCookTime(recipeCommand.getCookTime());
            recipe.setServings(recipeCommand.getServings());
            recipe.setSource(recipeCommand.getSource());
            recipe.setUrl(recipeCommand.getUrl());
            recipe.setDirections(recipe.getDirections());
            recipe.setNotes(notesConverter.convert(recipeCommand.getNotes()));
            recipe.setDifficulty(recipeCommand.getDifficulty());

            if (recipeCommand.getIngredients() != null && recipeCommand.getIngredients().size() > 0) {
                recipeCommand.getIngredients().forEach(
                        ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
            }

            if (recipeCommand.getCategories() != null && recipeCommand.getCategories().size() > 0) {
                recipeCommand.getCategories().forEach(
                        category -> recipe.getCategories().add(categoryConverter.convert(category)));
            }

            return recipe;

        }

        return null;
    }
}
