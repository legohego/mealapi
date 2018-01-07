package com.meal.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meal.exceptionhandler.NotFoundException;
import com.meal.models.Dish;
import com.meal.service.impl.DishServiceImpl;
import com.meal.services.DishService;

@RestController
public class DishController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public DishServiceImpl dishService;

	@RequestMapping("/dishes")
	@ResponseBody
	public ResponseEntity <Object> getDishes() throws NotFoundException {
		logger.info("HTTP Method: GET, URL + Values /dishes");
		List<Dish> dishList = dishService.getDishes();
		
		return new ResponseEntity<Object>(dishList, null != dishList? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dishes/")
	public Dish getFilteredDishes(@RequestParam(value = "filter", required = true) String filter,
			@RequestParam(value = "location", required = true) String location,
			@RequestParam(value = "dish", required = true) String dish) {
		logger.info("GET: /dish/?=" + "filter" + filter + "&location=" + location + "&dish=" + dish);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dishes/location&name/")
	public Dish getDishesByLocationAndName(@RequestParam(value = "location", required = true) String location,
			@RequestParam(value = "name", required = true) String name) {
		logger.info("GET: /dishes/location&name/?=location=" + location + "&name=" + name);
		List<Dish> dishList = dishService.getDishesByLocationAndName(location, name);
		
		return null;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/dish/")
	public ResponseEntity<Object> getDishes(@RequestParam(value = "id", required = true) String id) throws NotFoundException {
		logger.info("GET: /dish/?id=" + id);
		Dish dish = dishService.getDish(id);
		return new ResponseEntity<Object>(dish, null != dish ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dish/")
	public ResponseEntity<Object> createDish(@RequestBody Dish dish, @RequestParam(value = "id", required = true) String id) throws NotFoundException {
		dishService.createDish(dish, id);
		logger.info("POST: /dish/, RequestBody: " + dish.toString());
		return new ResponseEntity<Object>(null != id ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dish/")
	public ResponseEntity<Object> deleteDish(@RequestParam(value = "id", required = true) String id) {
		logger.info("DELETE: /dish/?id=" + id);
		id = dishService.deleteDish(id);
		return new ResponseEntity<Object>(null != id ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}
