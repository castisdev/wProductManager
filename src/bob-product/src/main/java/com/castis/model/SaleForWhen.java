package com.castis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleForWhen {
	@JsonProperty("start_time")
	private String startTime;
	@JsonProperty("end_time")
	private String endTime;
	
	public SaleForWhen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
}
