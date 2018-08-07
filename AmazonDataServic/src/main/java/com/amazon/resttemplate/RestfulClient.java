package com.amazon.resttemplate;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

/**
 * 
 * This is Restful client which provide the Rest template object to invoke the
 * rest service.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-06
 * 
 */

@Component("restfulClient")

public class RestfulClient {

	private RestTemplate restTemplate;

	public RestfulClient() {
		
		restTemplate = new RestTemplate();

	}

	public RestTemplate getRestTemplate() {

		return restTemplate;

	}

	public void setRestTemplate(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;

	}

}