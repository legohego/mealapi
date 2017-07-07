package com.meal.respository;

import org.springframework.data.repository.CrudRepository;

import com.meal.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, String>  {

}
