package com.github.flaviomarcilio.citiesapi.cities.resources;

import com.github.flaviomarcilio.citiesapi.cities.entities.City;
import com.github.flaviomarcilio.citiesapi.cities.repositories.CityRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/cities", produces = "application/json")
@Api(value = "Recurso REST para Cidades")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

       //1st
      @GetMapping
      @ApiOperation(value = "Lista todas as Cidades", response = City.class)
      @ApiResponses(value = {
              @ApiResponse(code = 200, message = "Cidades listadas com sucesso."),
              @ApiResponse(code = 401, message = "Autenticação necessária."),
              @ApiResponse(code = 500, message = "Erro interno.")
      })
      public List<City> cities() {
          return repository.findAll();
      }

    // 2nd - Pageable
    /*@GetMapping
    @ApiOperation(value = "Lista todas as Cidades", response = City.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cidades listadas com sucesso."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }*/

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtém uma Cidade pelo Id de cadastro", response = City.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cidade encontrada."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 404, message = "Cidade não encontrada."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<City> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
