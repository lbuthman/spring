package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.IngredientCommand;
import com.lbuthman.recipes.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasure) {
        this.unitOfMeasureConverter = unitOfMeasure;
    }

    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        if (ingredientCommand != null) {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(ingredientCommand.getId());
            ingredient.setDescription(ingredientCommand.getDescription());
            ingredient.setAmount(ingredientCommand.getAmount());
            ingredient.setUnitOfMeasure(unitOfMeasureConverter.convert(ingredientCommand.getUnitOfMeasure()));
            return ingredient;
        }

        return null;
    }
}
