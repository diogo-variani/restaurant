package com.vcompany.restaurant.api.repository;

import com.vcompany.restaurant.api.repository.entity.RestaurantEntity;
import com.vcompany.restaurant.api.repository.entity.RestaurantEntity_;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * It represents the restaurant repository (DAO).
 * Through this interface other classes will be able to access restaurant data from database.
 */
public interface IRestaurantRepository extends CrudRepository<RestaurantEntity, Long>, JpaSpecificationExecutor<RestaurantEntity> {

    /**
     * It defines the default sort strategy when querying the restaurant table.
     */
    Sort DEFAULT_SORT = Sort.by(
            Sort.Order.asc(  RestaurantEntity_.DISTANCE ),
            Sort.Order.desc( RestaurantEntity_.RATING ),
            Sort.Order.asc(  RestaurantEntity_.PRICE ));

    /**
     * It defines the default paging strategy when querying the restaurant table.
     */
    Pageable DEFAULT_PAGEABLE = PageRequest.of(0, 5, DEFAULT_SORT);
}
