package com.lbuthman.recipes.repositories;

import com.lbuthman.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRespository extends CrudRepository<Recipe, Long> {
}
