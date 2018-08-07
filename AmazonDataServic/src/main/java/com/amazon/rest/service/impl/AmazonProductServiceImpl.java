package com.amazon.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazon.model.AmazonProduct;
import com.amazon.rest.service.AmazonProductService;
import com.amazon.resttemplate.RestfulClient;

/**
 * This is amazon product service implementation class which is using rest
 * template to invoke the service.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-05
 */
@Service("amazonProductService")
public class AmazonProductServiceImpl implements AmazonProductService {

	private final Logger logger = LoggerFactory.getLogger(AmazonProductServiceImpl.class);

	private static final String SERVICE_URL = "http://ec2-52-15-52-170.us-east-2.compute.amazonaws.com:8080/transactions/v1/transactions?productId=AnyID";

	@Autowired
	private RestfulClient restfulClient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amazon.rest.service.AmazonProductService#getAmazonProducts()
	 */
	public List<AmazonProduct> getAmazonProducts() {

		final String method = "getAmazonProducts";
		logger.info(method + " :: Enter");

		List<AmazonProduct> amazonProducts = null;

		try {
			RestTemplate restTemplate = getRestfulClient().getRestTemplate();
			logger.debug(method + " :: restTemplate :" + restTemplate);

			// Invoke service using rest template
			ResponseEntity<AmazonProduct[]> response = restTemplate.getForEntity(SERVICE_URL, AmazonProduct[].class);
			logger.debug(method + " :: response :" + response.getStatusCode());

			amazonProducts = Arrays.asList(response.getBody());
			logger.debug(method + " :: amazonProducts size :" + amazonProducts.size());

		} catch (Exception e) {

			logger.error(method + " :: Exception: " + e.getMessage());
			// System.out.println("Exception: " + e.getMessage());
		}

		logger.info(method + " :: Exit");
		return amazonProducts;
	}

	public RestfulClient getRestfulClient() {
		return restfulClient;
	}

	public void setRestfulClient(RestfulClient restfulClient) {
		this.restfulClient = restfulClient;
	}
}
