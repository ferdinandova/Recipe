package com.tasty.recipe.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

}
