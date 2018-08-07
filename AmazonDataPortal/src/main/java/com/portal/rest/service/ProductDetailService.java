package com.portal.rest.service;

import java.util.List;

import com.amazon.model.AmazonProduct;

public interface ProductDetailService {

	public List<AmazonProduct> getAmazonProducts(String orderby, String direction, String from, String size);

}
