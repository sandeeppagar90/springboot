package com.amazon.rest.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.amazon.model.AmazonProduct;
import com.amazon.resttemplate.RestfulClient;

public class AmazonProductServiceImplTest {

	private AmazonProductServiceImpl amazonProductServiceImpl = null;
	private List<AmazonProduct> amazonProducts = new ArrayList<>();
	ResponseEntity<AmazonProduct[]> responseEntity = null;

	@Mock
	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {

		amazonProductServiceImpl = new AmazonProductServiceImpl();
		restTemplate = Mockito.mock(RestTemplate.class);

		RestfulClient restfulClient = new RestfulClient();
		restfulClient.setRestTemplate(restTemplate);
		amazonProductServiceImpl.setRestfulClient(restfulClient);

		// Data setup for testing
		AmazonProduct product = new AmazonProduct();
		product.setAmount(12.0);
		product.setArrangementId("1");
		product.setBookingDate("2017-05-25T10:40:20.090Z");
		product.setCategory("Home");
		product.setCounterPartyAccountNumber("1234");
		product.setCounterPartyName("Brian Wheeler");
		product.setCreditDebitIndicator("CRDT");
		product.setCurrency("USD");
		product.setCurrencyExchangeRate(1.33);
		product.setDescription("in imperdiet et commodo vulputate justo in blandit ultrices");
		product.setExternalArrangementId("09145149-85ac-4eb5-b031-dbe62165d206");
		product.setExternalId("EXTERNAL127");
		product.setId(1);
		product.setInstructedAmount(223.4);
		product.setInstructedCurrency("USD");
		product.setProductId("5cdb2224-8926-4b4d-a99f-1c9dfbbb4699");
		product.setReference("BCA-509608");
		product.setStatus("BILLED");
		product.setValueDate("2017-12-17T12:20:30.090Z");
		amazonProducts.add(product);

		responseEntity = new ResponseEntity<>(amazonProducts.toArray(new AmazonProduct[amazonProducts.size()]),
				HttpStatus.OK);

	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		when(restTemplate.getForEntity(Matchers.any(String.class), Matchers.any(Class.class)))
				.thenReturn(responseEntity);
		try {
			List<AmazonProduct> products = amazonProductServiceImpl.getAmazonProducts();
			assertNotNull("Cheking service response not null", products);
			String actual = products.get(0).getExternalArrangementId();
			assertEquals("Cheking equal to confirm that service invokation is working",
					"09145149-85ac-4eb5-b031-dbe62165d206", actual);
		} catch (Exception e) {
			fail();
		}
	}

}
