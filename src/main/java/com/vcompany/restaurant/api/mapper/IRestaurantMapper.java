package com.vcompany.restaurant.api.mapper;

import com.vcompany.restaurant.api.model.Restaurant;
import com.vcompany.restaurant.api.repository.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * It is responsible for mapping from RestaurantEntity to Restaurant.
 */
@Mapper( componentModel = "spring" )
public interface IRestaurantMapper {

    /**
     * It maps a restaurant entity to a restaurant.
     *
     * @param source the restaurant entity.
     *
     * @return the restaurant created based on the <code>source</code>.
     */
    @Mapping(target="cuisine", source="cuisine.description")
    Restaurant map(RestaurantEntity source);

    /**
     * It maps a list of a restaurant entities to a list of restaurant.
     *
     * @param source the list of restaurant entity used as source.
     * @return the list created from the list of entities.
     */
    List<Restaurant> map(List<RestaurantEntity> source);
}
