package com.castis.model;

import java.util.Collection;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class PurchaseProduct {

	@Id
	private String id;
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("sale_id")
	private String saleId;
	@JsonProperty("transaction_currency")
	private String transactionCurrency;
	@JsonProperty("purchase_price")
	private String purchasePrice;
	@JsonProperty("selling_price")
	private String sellingPrice;
	@JsonProperty("customer_id")
	private String customerId;
	
	public class Product {
		private String id;
		private String name;
				
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
	}
	
	private Product product;
	private Shipping shipping;
	private Collection<Payment> payments;
	@JsonProperty("applied_promotions")
	private Collection<Promotion> appliedPromotions;

	
	public PurchaseProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getSaleId() {
		return saleId;
	}


	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}


	public String getTransactionCurrency() {
		return transactionCurrency;
	}


	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}


	public String getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public String getSellingPrice() {
		return sellingPrice;
	}


	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Shipping getShipping() {
		return shipping;
	}


	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}


	public Collection<Payment> getPayments() {
		return payments;
	}


	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}


	public Collection<Promotion> getAppliedPromotions() {
		return appliedPromotions;
	}


	public void setAppliedPromotions(Collection<Promotion> appliedPromotions) {
		this.appliedPromotions = appliedPromotions;
	}

	public static void copyPurchaseProduct(PurchaseProduct src, PurchaseProduct dest){
		dest.setOrderId(src.getOrderId());
		dest.setSaleId(src.getSaleId());
		dest.setTransactionCurrency(src.getTransactionCurrency());
		dest.setPurchasePrice(src.getPurchasePrice());
		dest.setSellingPrice(src.getSellingPrice());
		dest.setCustomerId(src.getCustomerId());
		dest.setProduct(src.getProduct());
		dest.setShipping(src.getShipping());
		dest.setPayments(src.getPayments());
		dest.setAppliedPromotions(src.getAppliedPromotions());
	}
	
}
