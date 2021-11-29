package com.tasty.recipe.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authors")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqgen_author")
    @SequenceGenerator(name = "seqgen_author", sequenceName = "seq_author", initialValue = 100, allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "city_id")
    private int cityId;

}
