package com.meal.models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Dish")
public class Dish implements Serializable{
	@Id
	@GeneratedValue
    private String id;
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	private Restaurant restaurant;
	
    
    protected Dish() {
    	
    }
    public Dish(String id , String name, String description, Restaurant restaurant) {
    	this.id = id;
    	this.name = name;
    	this.description = description;

    	this.restaurant = restaurant;
    }
    public Dish(String name, String description) {
 
    	this.name = name;
    	this.description = description;
    }
    public Dish(String name, String description,  Restaurant restaurant) {
    	this.name = name;
    	this.description = description;

    	this.restaurant = restaurant;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString(){
		return this.id +":"+this.name +":"+this.description;
	}

}
