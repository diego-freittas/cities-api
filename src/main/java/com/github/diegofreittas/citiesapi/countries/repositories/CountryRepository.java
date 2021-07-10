package com.github.diegofreittas.citiesapi.countries.repositories;

import com.github.diegofreittas.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
