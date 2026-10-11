package com.kyrian.realestateapi.repository;

import com.kyrian.realestateapi.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}