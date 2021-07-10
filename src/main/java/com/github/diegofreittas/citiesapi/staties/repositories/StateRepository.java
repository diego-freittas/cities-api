package com.github.diegofreittas.citiesapi.staties.repositories;

import com.github.diegofreittas.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long > {
}
