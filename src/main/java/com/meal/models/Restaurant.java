package com.meal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant")
public class Restaurant {
	@Id
	@GeneratedValue
	private String id;
	@Column
	private String name;
	
	private Restaurant(){}
	public Restaurant( String name){
		
		this.setName(name);
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

}
