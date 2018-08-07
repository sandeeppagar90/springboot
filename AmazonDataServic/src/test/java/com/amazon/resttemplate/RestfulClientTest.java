package com.amazon.resttemplate;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestfulClientTest {

	private RestfulClient restfulClient = null;

	@Before
	public void setUp() throws Exception {

		restfulClient = new RestfulClient();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		RestTemplate restTemplate = restfulClient.getRestTemplate();

		assertNotNull("Object not null check", restTemplate);
	}

}
