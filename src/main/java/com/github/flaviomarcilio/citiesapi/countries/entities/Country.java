package com.github.flaviomarcilio.citiesapi.countries.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@ApiModel
public class Country {

    @Id
    @ApiModelProperty(notes = "Identificador único do País")
    private Long id;

    @Column(name = "nome")
    @ApiModelProperty(notes = "Nome do país em Inglês.")
    private String name;

    @Column(name = "nome_pt")
    @ApiModelProperty(notes = "Nome do país em Português.")
    private String portugueseName;

    @Column(name = "sigla")
    @ApiModelProperty(notes = "Sigla do país.")
    private String code;

    @ApiModelProperty(notes = "Código Bacen do país.")
    private Integer bacen;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPortugueseName() {
        return portugueseName;
    }

    public String getCode() {
        return code;
    }

    public Integer getBacen() {
        return bacen;
    }
}
