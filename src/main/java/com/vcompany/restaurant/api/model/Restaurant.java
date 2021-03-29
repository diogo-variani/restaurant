package com.vcompany.restaurant.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Restaurant
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-28T18:10:23.076274-03:00[America/Sao_Paulo]")


public class Restaurant   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("rating")
  private BigDecimal rating = null;

  @JsonProperty("distance")
  private BigDecimal distance = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("cuisine")
  private String cuisine = null;

  public Restaurant name(String name) {
    this.name = name;
    return this;
  }

  /**
   * It represents the restaurant's name
   * @return name
   **/
  @Schema(description = "It represents the restaurant's name")

  @Size(max=100)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Restaurant rating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }

  /**
   * It represents the customer's rating
   * minimum: 1
   * maximum: 5
   * @return rating
   **/
  @Schema(description = "It represents the customer's rating")

  @Valid
  @DecimalMin("1") @DecimalMax("5")   public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public Restaurant distance(BigDecimal distance) {
    this.distance = distance;
    return this;
  }

  /**
   * It is the distance from a specific point. unit - miles
   * minimum: 1
   * @return distance
   **/
  @Schema(description = "It is the distance from a specific point. unit - miles")

  @Valid
  @DecimalMin("1")  public BigDecimal getDistance() {
    return distance;
  }

  public void setDistance(BigDecimal distance) {
    this.distance = distance;
  }

  public Restaurant price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * It is the average price by one person. unit - dollar
   * @return price
   **/
  @Schema(description = "It is the average price by one person. unit - dollar")

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Restaurant cuisine(String cuisine) {
    this.cuisine = cuisine;
    return this;
  }

  /**
   * it describes the main cuisine of the restaurnt
   * @return cuisine
   **/
  @Schema(description = "it describes the main cuisine of the restaurnt")

  @Size(max=100)   public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Restaurant restaurant = (Restaurant) o;
    return Objects.equals(this.name, restaurant.name) &&
            Objects.equals(this.rating, restaurant.rating) &&
            Objects.equals(this.distance, restaurant.distance) &&
            Objects.equals(this.price, restaurant.price) &&
            Objects.equals(this.cuisine, restaurant.cuisine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, rating, distance, price, cuisine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Restaurant {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    cuisine: ").append(toIndentedString(cuisine)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
