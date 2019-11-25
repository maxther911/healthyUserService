package net.mrsistemas.healthy.business.persistence.repository;

import net.mrsistemas.healthy.business.persistence.entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Set<Country> getCountriesByNameStartingWith(String name);
}