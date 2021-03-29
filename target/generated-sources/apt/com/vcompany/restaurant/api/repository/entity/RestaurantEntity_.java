package com.vcompany.restaurant.api.repository.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RestaurantEntity.class)
public abstract class RestaurantEntity_ {

	public static volatile SingularAttribute<RestaurantEntity, Integer> distance;
	public static volatile SingularAttribute<RestaurantEntity, Double> price;
	public static volatile SingularAttribute<RestaurantEntity, String> name;
	public static volatile SingularAttribute<RestaurantEntity, Integer> rating;
	public static volatile SingularAttribute<RestaurantEntity, CuisineEntity> cuisine;
	public static volatile SingularAttribute<RestaurantEntity, Long> id;

	public static final String DISTANCE = "distance";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String RATING = "rating";
	public static final String CUISINE = "cuisine";
	public static final String ID = "id";

}

