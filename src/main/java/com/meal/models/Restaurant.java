package com.meal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant")
public class Restaurant {
	@Id
	@GeneratedValue
	private String id;
	@Column
	private String name;
	@ManyToOne
	private Business business;
	
	public Restaurant( String name, Business business){
		this.name = name ;
		this.business = business;
	}
	
	public Restaurant( String name){
		this.name = name;
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
	
	public String toString(){
		return this.id +":"+this.name +":"+this.id;
	}
	public void setBusiness(Business business) {
		this.business = business;
		
	}

}
