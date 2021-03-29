package com.vcompany.restaurant.api.repository.specification;

import com.vcompany.restaurant.api.repository.entity.CuisineEntity;
import com.vcompany.restaurant.api.repository.entity.CuisineEntity_;
import com.vcompany.restaurant.api.repository.entity.RestaurantEntity;
import com.vcompany.restaurant.api.repository.entity.RestaurantEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Join;

/**
 * This interface encapsulates the restaurant repository specifications.
 * It is will provide utility methods in order to generate a more complex query to be executed against the restaurant
 * entity.
 *
 * @see RestaurantEntity
 */
public interface RestaurantSpecification {

    /**
     * It is the like statement mask that will be applied to strings. It inserts the char % before and after a string.
     */
    String LIKE_MASK = "%%%s%%";

    /**
     * It creates a restaurant entity specification based on specific parameters. The parameters are just take into
     * consideration to be part of the criteria when they are specified. Empty strings or null values are not
     * considered to be part of the query.
     *
     * @param name the restaurant name. If null or empty, it will not be considered as part of the query.
     *             Optional condition.
     * @param rating the customer rating. If null it will not be considered as part of the query. Optional condition.
     * @param distance the distance. If null it will not be considered as part of the query. Optional condition.
     * @param price the average price by one person. If null it will not be considered as part of the query.
     *              Optional condition.
     * @param cuisine the kind of cuisine. If empty or null it will not be considered as part of the query.
     *                Optional condition.
     *
     * @return The final specification based on the parameters provided. It represents the criteria that will be
     * executed against the database.
     */
    static Specification<RestaurantEntity> create(String name, Integer rating, Integer distance, Double price, String cuisine) {
        return Specification.where( ObjectUtils.isEmpty( name ) ? null : name( name ))
                .and( ObjectUtils.isEmpty( rating ) ? null : rating( rating ) )
                .and( ObjectUtils.isEmpty( distance ) ? null : distance( distance ) )
                .and( ObjectUtils.isEmpty( price ) ? null : price( price ) )
                .and( ObjectUtils.isEmpty( cuisine ) ? null : cuisine( cuisine ));
    }

    /**
     * It creates the query criteria that finds by the restaurant name. The parameter provided is considered as part of
     * the restaurant name and it ignores case.
     *
     * @param name the part of the restaurnt name that will be used to search for restaurants.
     * @return the query criteria created based on the parameters
     */
    static Specification<RestaurantEntity> name( String name ){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like( criteriaBuilder.upper( root.get(RestaurantEntity_.name )), String.format(LIKE_MASK, name.toUpperCase()) );
    }

    /**
     * It creates the query criteria that finds by the customer rating.
     *
     * @param rating the customer rating.
     * @return the query criteria created based on the parameters
     */
    static Specification<RestaurantEntity> rating( Integer rating ){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo( root.get(RestaurantEntity_.rating ), rating );
    }

    /**
     * It creates the query criteria that finds by the distance.
     *
     * @param distance the restaurant distance.
     * @return the query criteria created based on the parameters
     */
    static Specification<RestaurantEntity> distance( Integer distance ){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo( root.get(RestaurantEntity_.distance ), distance );
    }

    /**
     * It creates the query criteria that finds by the restaurant price.
     *
     * @param price the restaurant price.
     * @return the query criteria created based on the parameters
     */
    static Specification<RestaurantEntity> price( Double price ){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo( root.get(RestaurantEntity_.price ), price );
    }

    /**
     * It creates the query criteria that finds by the kind of cuisine of the restaurant. The parameter provided
     * is considered as part of the kind of the cuisine and it ignores case.
     *
     * @param cuisine the kind of the cuisine of the restaurant.
     * @return the query criteria created based on the parameters
     */
    static Specification<RestaurantEntity> cuisine( String cuisine ){
        return (root, criteriaQuery, criteriaBuilder) -> {
            Join<RestaurantEntity, CuisineEntity> join = root.join(RestaurantEntity_.cuisine);
            return criteriaBuilder.like( criteriaBuilder.upper( join.get( CuisineEntity_.description ) ), String.format( LIKE_MASK, cuisine.toUpperCase() ) );
        };
    }
}
