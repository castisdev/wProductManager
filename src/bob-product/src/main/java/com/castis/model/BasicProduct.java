package com.castis.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class BasicProduct {

	@Id
	private String id;
	private String name;
	private String description;
	private boolean isPackage;
	private Classification classifications;
	
	
	
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

	
	public boolean isPackage() {
		return isPackage;
	}

	public void setPackage(boolean isPackage) {
		this.isPackage = isPackage;
	}
	
	public Classification getClassifications() {
		return classifications;
	}

	public void setClassifications(Classification classifications) {
		this.classifications = classifications;
	}

	@Override
	public String toString() {
		return "BasicProduct [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
	
}
