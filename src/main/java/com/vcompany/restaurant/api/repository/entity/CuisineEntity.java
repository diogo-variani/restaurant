package com.vcompany.restaurant.api.repository.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * It represents the cuisine table as an entity bean.
 * It will map the java object to the table columns and constraints.
 */
@Data
@Entity
@Table(name = "TB_CUISINE")
@SequenceGenerator(name = "SQ_TB_CUISINE_ID", allocationSize = 1)
@ToString
public class CuisineEntity {

    /**
     * It represents the cuisine table identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_CUISINE_ID")
    @Column(name = "CUISINE_ID")
    private Long id;

    /**
     * It represents the cuisine description.
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;
}
