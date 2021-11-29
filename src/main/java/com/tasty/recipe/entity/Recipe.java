package com.tasty.recipe.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "recipes")

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqgen_recipe")
    @SequenceGenerator(name = "seqgen_recipe", sequenceName = "seq_recipe", initialValue = 100, allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "needed_products")
    private String neededProducts;
    @Column(name = "instructions")
    private String instructions;
    @Column(name= "author_id")
    private int authorId;
    @Column(name = "time_for_cooking")
    private String timeForCooking;
}
