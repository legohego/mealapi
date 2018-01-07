package com.meal.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Business {
	
	@Id
	@GeneratedValue
    private String id;
	@Column
	private String name;
	@Column
	private String address;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Business() {
		
	}
	
	public Business(String name) {
		
	this.name = name;	
	}
	
}
