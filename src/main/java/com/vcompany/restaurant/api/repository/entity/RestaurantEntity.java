package com.vcompany.restaurant.api.repository.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * It represents the restaurant table as an entity bean.
 * It will map the java object to the table columns and constraints.
 */
@Data
@Entity
@Table(name = "TB_RESTAURANT")
@SequenceGenerator(name = "SQ_TB_RESTAURANT_ID", allocationSize = 1)
@ToString
public class RestaurantEntity {

    /**
     * It represents the restaurant table identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_RESTAURANT_ID")
    @Column(name = "RESTAURANT_ID")
    private Long id;

    /**
     * It represents the restaurant name column.
     */
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     * It represents the customer rating column.
     */
    @NotNull
    @Column(name = "RATING")
    private Integer rating;

    /**
     * It represents the distance column.
     */
    @NotNull
    @Column(name = "DISTANCE")
    private Integer distance;

    /**
     * It represents the price column.
     */
    @NotNull
    @Column(name = "PRICE")
    private Double price;

    /**
     * It represents the relationship with the table CUISINE.
     */
    @ManyToOne
    @JoinColumn(name="CUISINE_ID", nullable=false)
    private CuisineEntity cuisine;
}
