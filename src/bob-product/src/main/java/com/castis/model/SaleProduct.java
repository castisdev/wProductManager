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
	private String description;
	@JsonProperty("product")
	private BasicProduct product;
	
	@JsonProperty("available_payments")
	private AvailablePayment availablePayments;
	
	private Collection<Promotion> promotions;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public BasicProduct getProduct() {
		return product;
	}

	public void setProduct(BasicProduct product) {
		this.product = product;
	}

	public AvailablePayment getAvailablePayments() {
		return availablePayments;
	}

	public void setAvailablePayments(AvailablePayment availablePayments) {
		this.availablePayments = availablePayments;
	}

	public Collection<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Collection<Promotion> promotions) {
		this.promotions = promotions;
	}
	
	public static void copySaleProduct(SaleProduct src, SaleProduct dest){
		dest.setName(src.getName());
		dest.setDescription(src.getDescription());
		dest.setProduct(src.getProduct());
		dest.setAvailablePayments(src.getAvailablePayments());
		dest.setPromotions(src.getPromotions());
	}
	
}
