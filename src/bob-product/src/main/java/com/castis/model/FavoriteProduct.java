package com.castis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavoriteProduct {

	@Id
	private String id;
	private String name;
	private String productId;
	
	public FavoriteProduct() {
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
	
	
}
