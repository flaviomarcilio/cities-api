package com.github.flaviomarcilio.citiesapi.states.resources;

import com.github.flaviomarcilio.citiesapi.states.entities.State;
import com.github.flaviomarcilio.citiesapi.states.repositories.StateRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/states", produces = "application/json")
@Api(value = "Recurso REST para Estados")
public class StateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os Estados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estados listados com sucesso."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 404, message = "Estado não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public List<State> states() {
        return repository.findAll();
    }
}