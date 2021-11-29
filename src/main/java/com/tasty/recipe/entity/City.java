package com.tasty.recipe.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqgen_city")
    @SequenceGenerator(name = "seqgen_city", sequenceName = "seq_city", initialValue = 100, allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column (name = "city_name")
    private String name;
    @Column (name = "country")
    private String country;

}
