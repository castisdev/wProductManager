package com.castis.model;

import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PricingPlan {

	private String id;
	private String name;
	private String price;
	private String currency;
	@JsonProperty("default")
	private Boolean isDefault;
	
	@JsonProperty("sale_for_where")
	private Collection<String> saleForWhere;
	@JsonProperty("sale_for_who")
	private Collection<String> saleForWho;
	@JsonProperty("sale_for_how")
	private Collection<String> saleForHow;
	@JsonProperty("sale_for_when")
	private SaleForWhen saleForWhen;
	
	public PricingPlan() {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Collection<String> getSaleForWhere() {
		return saleForWhere;
	}

	public void setSaleForWhere(Collection<String> saleForWhere) {
		this.saleForWhere = saleForWhere;
	}

	public Collection<String> getSaleForWho() {
		return saleForWho;
	}

	public void setSaleForWho(Collection<String> saleForWho) {
		this.saleForWho = saleForWho;
	}

	public Collection<String> getSaleForHow() {
		return saleForHow;
	}

	public void setSaleForHow(Collection<String> saleForHow) {
		this.saleForHow = saleForHow;
	}

	public SaleForWhen getSaleForWhen() {
		return saleForWhen;
	}

	public void setSaleForWhen(SaleForWhen saleForWhen) {
		this.saleForWhen = saleForWhen;
	}

	

}
