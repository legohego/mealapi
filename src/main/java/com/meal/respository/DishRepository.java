package com.meal.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meal.models.Dish;
@Repository
public interface DishRepository extends CrudRepository<Dish, String> {

}
