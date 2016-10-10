package com.castis.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class BasicProduct {

	@Id
	private String id;
	private String name;
	private String description;
	private boolean isPackage;
	private Classification classifications;
	private String image;
	@JsonProperty("creation_time")
	private String creationTime;
	private Specification specifications;
	@JsonProperty("item_list")
	private ItemList itemList;
	@JsonProperty("pricing_plan_list")
	private PricingPlanList pricingPlanList;
		
	
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
	
	public boolean getIsPackage() {
		return isPackage;
	}

	public void setIsPackage(boolean isPackage) {
		this.isPackage = isPackage;
	}
	
	public Classification getClassifications() {
		return classifications;
	}

	public void setClassifications(Classification classifications) {
		this.classifications = classifications;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public Specification getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Specification specifications) {
		this.specifications = specifications;
	}

	public ItemList getItemList() {
		return itemList;
	}

	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}

	public PricingPlanList getPricingPlanList() {
		return pricingPlanList;
	}

	public void setPricingPlanList(PricingPlanList pricingPlanList) {
		this.pricingPlanList = pricingPlanList;
	}

	public void setPackage(boolean isPackage) {
		this.isPackage = isPackage;
	}

	@Override
	public String toString() {
		return "BasicProduct [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	public static void copyBasicProduct(BasicProduct src, BasicProduct dest){
		dest.setName(src.getName());
		dest.setDescription(src.getDescription());
		dest.setIsPackage(src.getIsPackage());
		dest.setClassifications(src.getClassifications());
		dest.setImage(src.getImage());
		dest.setCreationTime(src.getCreationTime());
		dest.setSpecifications(src.getSpecifications());
		dest.setItemList(src.getItemList());
		dest.setPricingPlanList(src.getPricingPlanList());
	}
	
}
