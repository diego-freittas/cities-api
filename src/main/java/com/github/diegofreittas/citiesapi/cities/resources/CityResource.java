package com.github.diegofreittas.citiesapi.cities.resources;

import com.github.diegofreittas.citiesapi.cities.entities.City;
import com.github.diegofreittas.citiesapi.cities.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityResource {

    @Autowired
    private CityRepository repository;

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<City> cities(Pageable page) {
        return repository.findAll(page);
    }
}
