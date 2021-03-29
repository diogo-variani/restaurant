package com.vcompany.restaurant.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vcompany.restaurant.api.model.Restaurant;
import com.vcompany.restaurant.api.service.IRestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-28T18:50:22.197436-03:00[America/Sao_Paulo]")
@RestController
public class RestaurantsApiController implements RestaurantsApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final IRestaurantService restaurantService;

    @org.springframework.beans.factory.annotation.Autowired
    public RestaurantsApiController(ObjectMapper objectMapper, HttpServletRequest request, IRestaurantService restaurantService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.restaurantService = restaurantService;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Restaurant>> findRestaurants(@Size(max = 100) @Valid String name, @Min(1) @Max(5) @Valid Integer rating, @Min(1) @Max(10) @Valid Integer distance, @Valid Double price, @Size(max = 100) @Valid String cuisine) {
        List<Restaurant> restaurants = restaurantService.findRestaurants(name, rating, distance, price, cuisine);
        return ResponseEntity.ok( restaurants );
    }
}
