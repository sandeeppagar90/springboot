package com.amazon.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmazonProductResponseTest {

	private AmazonProductResponse amazonProductResponse ;
	
	@Before
	public void setUp() throws Exception {
		
		amazonProductResponse = new AmazonProductResponse();
		
		ServiceResponseBody responseBody = new ServiceResponseBody();
		responseBody.setAmazonProducts(null);
		amazonProductResponse.setResponseBody(responseBody );
		
		ServiceResponseHeader responseHeader = new ServiceResponseHeader();
		responseHeader.setStatus("success");
		responseHeader.setStatusCode("1");
		amazonProductResponse.setResponseHeader(responseHeader );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {


		String status = amazonProductResponse.getResponseHeader().getStatusCode();
		assertEquals("1", status);
		
		List<AmazonProduct> amazonProducts = amazonProductResponse.getResponseBody().getAmazonProducts();
		assertEquals(null, amazonProducts);
	}

}
