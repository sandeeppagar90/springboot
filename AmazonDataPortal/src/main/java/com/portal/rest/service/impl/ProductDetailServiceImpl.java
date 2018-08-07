package com.portal.rest.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amazon.model.AmazonProduct;
import com.amazon.model.AmazonProductResponse;
import com.portal.rest.service.ProductDetailService;

/**
 * This is service interface implementation class which is using rest
 * template to invoke the web service.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-06
 */
@Component("productDetailService")
public class ProductDetailServiceImpl implements ProductDetailService {

	private final Logger logger = LoggerFactory.getLogger(ProductDetailServiceImpl.class);

	private final String HOST = "http://localhost:8080";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amazon.rest.service.AmazonProductService#getAmazonProducts()
	 */
	public List<AmazonProduct> getAmazonProducts(String orderby, String direction, String from, String size) {

		final String method = "getAmazonProducts";
		logger.info(method + " :: Enter");

		logger.info(
				method + " :: orderBy: " + orderby + " direction: " + direction + "from: " + from + "size: " + size);

		List<AmazonProduct> amazonProducts = null;

		try {
			RestTemplate restTemplate = new RestTemplate();
			logger.info(method + " :: restTemplate :" + restTemplate);

			String queryString = "orderBy=" + orderby + "&direction=" + direction + "&from=" + from + "&size=" + size;
			final String serviceUrl = HOST + "/v2/transactions?" + queryString;
			// Invoke service using rest template
			ResponseEntity<AmazonProductResponse> response = restTemplate.getForEntity(serviceUrl,
					AmazonProductResponse.class);
			logger.debug(method + " :: response :" + response.getStatusCode());

			AmazonProductResponse productResponse = response.getBody();
			amazonProducts = productResponse.getResponseBody().getAmazonProducts();
			logger.debug(method + " :: amazonProducts size :" + amazonProducts.size());

		} catch (Exception e) {

			logger.error(method + " :: Exception: " + e);
			throw e;			
		}

		logger.info(method + " :: Exit");
		return amazonProducts;
	}

}
