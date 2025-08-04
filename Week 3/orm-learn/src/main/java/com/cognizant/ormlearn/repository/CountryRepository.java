package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

/**
 * This interface extends JpaRepository. Spring Data JPA will automatically
 * create a bean that implements this interface, providing us with all the
 * standard CRUD (Create, Read, Update, Delete) database operations.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    // JpaRepository<EntityType, PrimaryKeyType>
    // Our entity is Country, and its primary key (the 'code' field) is a String.
}
