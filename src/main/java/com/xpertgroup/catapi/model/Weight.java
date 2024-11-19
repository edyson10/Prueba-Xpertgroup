package com.xpertgroup.catapi.model;

import lombok.Data;

@Data
public class Weight {

	private String imperial;
    private String metric;
    
	public Weight(String imperial, String metric) {
		super();
		this.imperial = imperial;
		this.metric = metric;
	}
	
	public String getImperial() {
		return imperial;
	}
	
	public void setImperial(String imperial) {
		this.imperial = imperial;
	}
	
	public String getMetric() {
		return metric;
	}
	
	public void setMetric(String metric) {
		this.metric = metric;
	} 
}
