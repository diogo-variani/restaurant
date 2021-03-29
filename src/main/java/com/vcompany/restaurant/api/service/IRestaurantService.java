package com.vcompany.restaurant.api.service;

import com.vcompany.restaurant.api.model.Restaurant;

import java.util.List;

/**
 * Service that encapsulates all restaurant entity operations.
 */
public interface IRestaurantService {

    /**
     * It tries to find by restaurants based on specific parameters. If any parameter is empty or null, then it is not
     * taken into consideration.
     *
     * @param name the restaurant name.
     * @param rating the customer rating.
     * @param distance the distance.
     * @param price the average price by one person.
     * @param cuisine the kind of cuisine
     *
     * @return a list of restaurants found. If none restaurant is found, then an empty list is returned.
     */
    List<Restaurant> findRestaurants(String name, Integer rating, Integer distance, Double price, String cuisine );
}
