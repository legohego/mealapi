package com.meal.respository;

import org.springframework.data.repository.CrudRepository;

import com.meal.models.Dish;
import com.meal.models.User;

public interface UserRepository extends CrudRepository<User, String> {

}
