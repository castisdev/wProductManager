package com.castis.model;

import java.util.Collection;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="saleProduct")
public class SaleProduct {

	@Id
	private String id;
	private String name;
	private String productId;
	@JsonProperty("description")
	private Collection<String> description;
	
	public SaleProduct() {
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Collection<String> getDescription() {
		return description;
	}

	public void setDescription(Collection<String> description) {
		this.description = description;
	}
	
	
	
}
