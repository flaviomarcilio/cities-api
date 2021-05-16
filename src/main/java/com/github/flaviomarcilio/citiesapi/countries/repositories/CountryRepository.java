package com.github.flaviomarcilio.citiesapi.countries.repositories;

import com.github.flaviomarcilio.citiesapi.countries.entities.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
