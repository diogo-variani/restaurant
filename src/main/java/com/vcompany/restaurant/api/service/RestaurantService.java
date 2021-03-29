package com.vcompany.restaurant.api.service;

import com.vcompany.restaurant.api.mapper.IRestaurantMapper;
import com.vcompany.restaurant.api.model.Restaurant;
import com.vcompany.restaurant.api.repository.IRestaurantRepository;
import com.vcompany.restaurant.api.repository.entity.RestaurantEntity;
import com.vcompany.restaurant.api.repository.specification.RestaurantSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vcompany.restaurant.api.repository.IRestaurantRepository.DEFAULT_PAGEABLE;

/**
 * It encapsulates the restaurant entity business logic.
 */
@Service
public class RestaurantService implements IRestaurantService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * The restaurant repository.
     */
    private final IRestaurantRepository repository;

    /**
     * The mapper that will map entity to model and vice versa.
     */
    private final IRestaurantMapper mapper;

    public RestaurantService(IRestaurantRepository repository, IRestaurantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Restaurant> findRestaurants(String name, Integer rating, Integer distance, Double price, String cuisine) {
        log.info("Finding restaurants based on the following parameters. name: {}, rating: {}, distance: {}, price: {} and cuisine: {}", name, rating, distance, price, cuisine);

        Specification<RestaurantEntity> specification = RestaurantSpecification.create(name, rating, distance, price, cuisine);

        Page<RestaurantEntity> pageEntities = repository.findAll(specification, DEFAULT_PAGEABLE);
        List<RestaurantEntity> entities = pageEntities.getContent();

        log.info("Found {} restaurants based on the following parameters. name: {}, rating: {}, distance: {}, price: {} and cuisine: {}", entities.size(), name, rating, distance, price, cuisine);

        return mapper.map( entities );
    }
}