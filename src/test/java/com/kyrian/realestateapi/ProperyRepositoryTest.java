package com.kyrian.realestateapi;

import com.kyrian.realestateapi.model.Property;
import com.kyrian.realestateapi.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PropertyRepositoryTest {

    @Autowired
    private PropertyRepository repository;

    private Property buildProperty(String title) {
        Property property = new Property();
        property.setTitle(title);
        property.setAddress("456 Oak Avenue");
        property.setCity("Calgary");
        property.setPrice(525000.0);
        property.setBedrooms(3);
        property.setBathrooms(2);
        property.setStatus("FOR_SALE");
        return property;
    }

    @Test
    void savesAndFindsAProperty() {
        Property saved = repository.save(buildProperty("Test house"));

        assertNotNull(saved.getId());

        Optional<Property> found = repository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("Test house", found.get().getTitle());
    }

    @Test
    void deletesAProperty() {
        Property saved = repository.save(buildProperty("House to delete"));

        repository.deleteById(saved.getId());

        assertTrue(repository.findById(saved.getId()).isEmpty());
    }
}