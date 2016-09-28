package com.castis.model;

import org.springframework.data.mongodb.core.mapping.Document;

public class Classification {

	private String large;
	private String medium;
	private String small;
	
	public Classification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}
		
	
}
