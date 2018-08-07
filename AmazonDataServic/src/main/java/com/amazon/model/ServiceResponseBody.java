package com.amazon.model;

import java.util.List;

public class ServiceResponseBody {

	private List<AmazonProduct> amazonProducts;

	public List<AmazonProduct> getAmazonProducts() {
		return amazonProducts;
	}

	public void setAmazonProducts(List<AmazonProduct> amazonProducts) {
		this.amazonProducts = amazonProducts;
	}
}
