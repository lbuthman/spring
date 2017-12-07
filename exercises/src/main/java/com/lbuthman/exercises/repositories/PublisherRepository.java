package com.lbuthman.exercises.repositories;

import com.lbuthman.exercises.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
