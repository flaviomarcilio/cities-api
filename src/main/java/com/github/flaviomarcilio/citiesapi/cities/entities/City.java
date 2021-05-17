package com.github.flaviomarcilio.citiesapi.cities.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
@ApiModel
public class City {

    @Id
    @ApiModelProperty(notes = "Identificador único do Estado")
    private Long id;

    @Column(name = "nome")
    @ApiModelProperty(notes = "Nome do Estado")
    private String name;

    @ApiModelProperty(notes = "Sigla do Estado")
    private Integer uf;

    @ApiModelProperty(notes = "Código IBGE da Cidade")
    private Integer ibge;

    // 1st
    @Column(name = "lat_lon")
    @ApiModelProperty(notes = "Geolocalização da Cidade")
    private String geolocation;

    // 2nd
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    @ApiModelProperty(notes = "Localização da Cidade em Longitude e Latitude")
    private Point location;

    public City() {
    }

    /*public City(final Long id, final String name, final Integer uf, final Integer ibge,
                final String geolocation, final Point location) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.ibge = ibge;
        this.geolocation = geolocation;
        this.location = location;
    }*/

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public Point getLocation() {
        return location;
    }
}
