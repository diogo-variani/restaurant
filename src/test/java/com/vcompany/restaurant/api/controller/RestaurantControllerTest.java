package com.vcompany.restaurant.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest extends BaseControllerTest {

    private static final int MAX_RECORDS = 5;

    @Test
    public void Given_NoParameters_When_RestaurantSearchIsExecuted_Then_NonEmptyListIsReturned() throws Exception {
        find(null, null, null, null, null,
            ResultMatcher.matchAll(
                status().isOk(),
                jsonPath("$").isArray(),
                jsonPath("$").isNotEmpty(),
                jsonPath("$", hasSize(MAX_RECORDS))
            )
        );
    }

    @Test
    public void Given_KindOfCuisine_When_RestaurantSearchIsExecuted_Then_ListIsReturned() throws Exception {
        final String cuisine = "Spanish";

        find(null, null, null, null, cuisine,
                ResultMatcher.matchAll(
                        status().isOk(),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$[*].cuisine").value( everyItem( equalTo(cuisine) ) )
                )
        );
    }

    @Test
    public void Given_RestaurantName_When_RestaurantSearchIsExecuted_Then_ListIsReturned() throws Exception {
        final String name = "Delicious";

        find(name, null, null, null, null,
                ResultMatcher.matchAll(
                        status().isOk(),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$[*].name").value( everyItem( containsString(name) ) )
                )
        );
    }

    @Test
    public void Given_CustomerRating_When_RestaurantSearchIsExecuted_Then_ListIsReturned() throws Exception {
        final Integer rating = 3;

        find(null, rating, null, null, null,
                ResultMatcher.matchAll(
                        status().isOk(),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$[*].rating").value( everyItem( greaterThanOrEqualTo(rating) ) )
                )
        );
    }

    @Test
    public void Given_Distance_When_RestaurantSearchIsExecuted_Then_ListIsReturned() throws Exception {
        final Integer distance = 5;

        find(null, null, distance, null, null,
                ResultMatcher.matchAll(
                        status().isOk(),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$[*].distance").value( everyItem( lessThanOrEqualTo(distance) ) )
                )
        );
    }

    @Test
    public void Given_PriceSpecified_When_RestaurantSearchIsExecuted_Then_ListIsReturned() throws Exception {
        final Double price = Double.valueOf(50d);

        find(null, null, null, price, null,
                ResultMatcher.matchAll(
                        status().isOk(),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$[*].price").value( everyItem( lessThanOrEqualTo(price) ) )
                )
        );
    }

    @Test
    public void Given_InvalidPrice_When_RestaurantSearchIsExecuted_Then_ErrorIsReturned() throws Exception {
        String invalidValue = "sample";

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("price", invalidValue);

        find( parameters,
            ResultMatcher.matchAll(
                    status().isBadRequest(),
                    jsonPath("$").exists(),
                    jsonPath("$.code").value( is(HttpStatus.BAD_REQUEST.value()) ),
                    jsonPath("$.description").value( containsString( invalidValue ) )
            )
        );
    }

    @Test
    public void Given_LargeName_When_RestaurantSearchIsExecuted_Then_ErrorIsReturned() throws Exception {
        String largeName = IntStream.range(0, 30)
                .mapToObj(x -> "Delicious")
                .collect(Collectors.joining());

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("name", largeName);

        find( parameters,
                ResultMatcher.matchAll(
                        status().isBadRequest(),
                        jsonPath("$").exists(),
                        jsonPath("$.code").value( is(HttpStatus.BAD_REQUEST.value()) ),
                        jsonPath("$.description").value( containsString( "name" ) )
                )
        );
    }
}
