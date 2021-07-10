package com.github.diegofreittas.citiesapi.countries.resources;

import com.github.diegofreittas.citiesapi.countries.entities.Country;
import com.github.diegofreittas.citiesapi.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    //http://localhost:8080/countries?page=0&size=10&sort=name,asc exemplo de uma requisicao GET paginada
    //http://localhost:8080/countries?page=2&size=10&sort=id,asc
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity findByID(@PathVariable Long id){
        Optional<Country> opiCountry = repository.findById(id);
        if(opiCountry.isPresent()) {
            return ResponseEntity.ok().body(opiCountry.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
