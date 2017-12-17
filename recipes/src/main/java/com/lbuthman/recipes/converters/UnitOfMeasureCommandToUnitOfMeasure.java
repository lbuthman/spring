package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.UnitOfMeasureCommand;
import com.lbuthman.recipes.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if (unitOfMeasureCommand != null) {

            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(unitOfMeasureCommand.getId());
            unitOfMeasure.setDescription(unitOfMeasureCommand.getDescription());
            return unitOfMeasure;
        }

        return null;
    }
}
