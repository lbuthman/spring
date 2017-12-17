package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.CategoryCommand;
import com.lbuthman.recipes.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {

        if (categoryCommand != null) {
            Category category = new Category();
            category.setId(categoryCommand.getId());
            category.setDescription(categoryCommand.getDescription());
            return category;
        }

        return null;
    }
}
