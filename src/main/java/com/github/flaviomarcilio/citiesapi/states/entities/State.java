package com.github.flaviomarcilio.citiesapi.states.entities;

import com.github.flaviomarcilio.citiesapi.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@ApiModel
public class State {

    @Id
    @ApiModelProperty(notes = "Identificador único do Estado")
    private Long id;

    @Column(name = "nome")
    @ApiModelProperty(notes = "Nome do Estado")
    private String name;

    @ApiModelProperty(notes = "Sigla do Estado")
    private String uf;

    @ApiModelProperty(notes = "Código IBGE")
    private Integer ibge;

    // 1st - Retorna o Id do pais
    /*@Column(name = "pais")
    private Integer countryId;*/

    // 2nd - @ManyToOne - Retorna o pais
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    public Country getCountry() {
        return country;
    }

    // Retorna o Id do pais
    /*public Integer getCountryId() {
        return countryId;
    }*/
}
