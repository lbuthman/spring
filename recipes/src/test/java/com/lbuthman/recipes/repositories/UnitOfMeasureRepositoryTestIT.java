package com.lbuthman.recipes.repositories;

import com.lbuthman.recipes.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {

    @Autowired
    private UnitOfMeasureRepository repository;

    @Test
    @DirtiesContext
    public void findByDescriptionTeaspoon() {

        Optional<UnitOfMeasure> unit = repository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", unit.get().getDescription());
    }

    @Test
    public void findByDescriptionEach() {

        Optional<UnitOfMeasure> unit = repository.findByDescription("Each");
        assertEquals("Each", unit.get().getDescription());
    }
}