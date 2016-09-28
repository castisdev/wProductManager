package com.castis.model;



import java.util.Collection;

import javax.persistence.Embedded;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class Product {

	@Embedded
	private Collection<BasicProduct> products;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<BasicProduct> getProducts() {
		return products;
	}

	public void setProducts(Collection<BasicProduct> products) {
		this.products = products;
	}
		
}
