package com.github.diegofreittas.citiesapi.repository;

import com.github.diegofreittas.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
