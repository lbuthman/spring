package com.lbuthman.exercises.repositories;

import com.lbuthman.exercises.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
