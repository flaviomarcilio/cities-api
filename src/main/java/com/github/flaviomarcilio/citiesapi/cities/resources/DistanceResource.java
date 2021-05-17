package com.github.flaviomarcilio.citiesapi.cities.resources;

import com.github.flaviomarcilio.citiesapi.cities.entities.City;
import com.github.flaviomarcilio.citiesapi.cities.service.DistanceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/distances")
@Api(value = "Recurso REST para distância entre duas Cidades")
public class DistanceResource {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    @ApiOperation(value = "Cálculo da distância em Milhas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cálculo realizado com sucesso."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 404, message = "Cidade não encontrada."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return service.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    @ApiOperation(value = "Cálculo da distância em Metros")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cálculo realizado com sucesso."),
            @ApiResponse(code = 401, message = "Autenticação necessária."),
            @ApiResponse(code = 404, message = "Cidade não encontrada."),
            @ApiResponse(code = 500, message = "Erro interno.")
    })
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return service.distanceByCubeInMeters(city1, city2);
    }

    /*@GetMapping("/by-math")
    public Double byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadius unit) {
        log.info("byMath");
        return service.distanceUsingMath(city1, city2, unit);
    }*/
}