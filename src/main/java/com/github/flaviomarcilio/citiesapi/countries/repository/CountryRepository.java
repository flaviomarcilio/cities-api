package com.github.flaviomarcilio.citiesapi.countries.repository;

import com.github.flaviomarcilio.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
