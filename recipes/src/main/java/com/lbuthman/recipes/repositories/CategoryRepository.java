package com.lbuthman.recipes.repositories;

import com.lbuthman.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
