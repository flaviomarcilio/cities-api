package com.github.flaviomarcilio.citiesapi.countries.resources;

import com.github.flaviomarcilio.citiesapi.countries.entities.Country;
import com.github.flaviomarcilio.citiesapi.countries.repositories.CountryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/countries", produces = "application/json")
@Api(value = "Recurso REST para Países")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    // Substitui o Autowired
//    public CountryResource(CountryRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping()
    @ApiOperation(value = "Lista todos os Países")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Países listados com sucesso."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 404, message = "País não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public List<Country> countries() {
        return repository.findAll();
    }

    /*@GetMapping
    @ApiOperation(value = "Lista todos os países", notes = "Lista paginada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Países listados com sucesso."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }*/

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtém um país pelo id de cadastro", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "País encontrado."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 404, message = "País não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
