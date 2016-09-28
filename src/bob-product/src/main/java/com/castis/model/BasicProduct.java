package com.castis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="basicProduct")
public class BasicProduct {

	@Id
	private String id;
	private String name;
	private String description;
	
	
	public BasicProduct() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BasicProduct [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
	
}
