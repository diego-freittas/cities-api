package com.github.diegofreittas.citiesapi.staties.entities;

import com.github.diegofreittas.citiesapi.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
@Data
//utilizando uma biblioteca des terceiros para ensinar o Hibernate a mapaer o campo ddd que eh do tipo json na tabela para uma List
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {
    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;
    private Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")//utilizando uma biblioteca des terceiros para ensinar o Hibernate a mapaer o campo ddd que eh do tipo json na tabela para uma List
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;


}
