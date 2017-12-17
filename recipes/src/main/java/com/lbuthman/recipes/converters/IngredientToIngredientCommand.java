package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.IngredientCommand;
import com.lbuthman.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient != null) {
            IngredientCommand ingredientCommand = new IngredientCommand();
            ingredientCommand.setId(ingredient.getId());
            ingredientCommand.setDescription(ingredient.getDescription());
            ingredientCommand.setAmount(ingredient.getAmount());
            ingredientCommand.setUnitOfMeasure(unitOfMeasureConverter.convert(ingredient.getUnitOfMeasure()));
            return ingredientCommand;
        }
        return null;
    }
}
