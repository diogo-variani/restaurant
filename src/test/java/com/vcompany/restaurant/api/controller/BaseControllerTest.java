package com.vcompany.restaurant.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public abstract class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    protected static final String DEFAULT_PATH = "/restaurants";

    private MultiValueMap<String, String> createParameters(String name, Integer rating, Integer distance, Double price, String cuisine  ){
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

        if(!ObjectUtils.isEmpty( name )){
            parameters.add("name", name );
        }
        if(!ObjectUtils.isEmpty( rating )){
            parameters.add("rating", rating.toString() );
        }
        if(!ObjectUtils.isEmpty( distance )){
            parameters.add("distance", distance.toString() );
        }
        if(!ObjectUtils.isEmpty( price )){
            parameters.add("price", price.toString() );
        }
        if(!ObjectUtils.isEmpty( cuisine )){
            parameters.add("cuisine", cuisine );
        }

        return parameters;
    }

    protected MvcResult find(String name, Integer rating, Integer distance, Double price, String cuisine, ResultMatcher matcher) throws Exception {
        MultiValueMap<String, String> parameters = createParameters( name, rating, distance, price, cuisine );
        return find(parameters, matcher);
    }

    protected MvcResult find(MultiValueMap<String, String> parameters, ResultMatcher matcher) throws Exception {
        return mockMvc.perform(get(DEFAULT_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .params(parameters))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(matcher)
                .andReturn();
    }
}