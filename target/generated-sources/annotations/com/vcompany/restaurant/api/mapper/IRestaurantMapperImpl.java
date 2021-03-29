package com.vcompany.restaurant.api.mapper;

import com.vcompany.restaurant.api.model.Restaurant;
import com.vcompany.restaurant.api.repository.entity.CuisineEntity;
import com.vcompany.restaurant.api.repository.entity.RestaurantEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-29T16:16:09-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class IRestaurantMapperImpl implements IRestaurantMapper {

    @Override
    public Restaurant map(RestaurantEntity source) {
        if ( source == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setCuisine( sourceCuisineDescription( source ) );
        restaurant.setName( source.getName() );
        if ( source.getRating() != null ) {
            restaurant.setRating( BigDecimal.valueOf( source.getRating() ) );
        }
        if ( source.getDistance() != null ) {
            restaurant.setDistance( BigDecimal.valueOf( source.getDistance() ) );
        }
        restaurant.setPrice( source.getPrice() );

        return restaurant;
    }

    @Override
    public List<Restaurant> map(List<RestaurantEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<Restaurant> list = new ArrayList<Restaurant>( source.size() );
        for ( RestaurantEntity restaurantEntity : source ) {
            list.add( map( restaurantEntity ) );
        }

        return list;
    }

    private String sourceCuisineDescription(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }
        CuisineEntity cuisine = restaurantEntity.getCuisine();
        if ( cuisine == null ) {
            return null;
        }
        String description = cuisine.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }
}
