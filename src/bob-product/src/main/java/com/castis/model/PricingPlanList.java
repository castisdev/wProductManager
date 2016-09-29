package com.castis.model;

import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PricingPlanList {
	@JsonProperty("pricing_plans")
	private Collection<PricingPlan> pricingPlans;

	
	public PricingPlanList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<PricingPlan> getPricingPlans() {
		return pricingPlans;
	}

	public void setPricingPlans(Collection<PricingPlan> pricingPlans) {
		this.pricingPlans = pricingPlans;
	}
	
	
}
