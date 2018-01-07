package com.meal.respository;

import org.springframework.data.repository.CrudRepository;

import com.meal.models.Business;

public interface BusinessRepository extends CrudRepository<Business, String>{

}
