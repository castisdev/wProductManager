package com.castis.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class FavoriteProduct {

	@Id
	private String id;
	private String name;
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("creation_time")
	private String creationTime;
	
	public class Product {
		private String id;
		private String name;
		@JsonProperty("now_price")
		private String nowPrice;
		private String currency;
				
		public Product() {
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
		public String getNowPrice() {
			return nowPrice;
		}
		public void setNowPrice(String nowPrice) {
			this.nowPrice = nowPrice;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		
	}
	
	private Product product;
	
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
		
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static void copyFavoriteProduct(FavoriteProduct src, FavoriteProduct dest){
		dest.setName(src.getName());
		dest.setCustomerId(src.getCustomerId());
		dest.setCreationTime(src.getCreationTime());
		dest.setProduct(src.getProduct());
	}
}
