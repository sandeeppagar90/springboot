package com.amazon.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceResponseBodyTest {

	private ServiceResponseBody serviceResponseBody;

	@Before
	public void setUp() throws Exception {

		serviceResponseBody = new ServiceResponseBody();
		List<AmazonProduct> amazonProducts = new ArrayList<AmazonProduct>();
		AmazonProduct amazonProduct = new AmazonProduct();
		amazonProduct.setId(1);
		amazonProducts.add(amazonProduct);
		serviceResponseBody.setAmazonProducts(amazonProducts);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		final int id = serviceResponseBody.getAmazonProducts().get(0).getId();
		assertEquals(1, id);
	}

}
