package com.amazon.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amazon.model.AmazonProduct;
import com.amazon.rest.service.AmazonProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(RestTransactionsController.class)
public class RestTransactionsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AmazonProductService amazonProductService;

	private RestTransactionsController restTransactionsController = null;
	private List<AmazonProduct> amazonProducts = new ArrayList<>();

	@Before
	public void setUp() throws Exception {

		restTransactionsController = new RestTransactionsController();
		restTransactionsController.setAmazonProductService(amazonProductService);

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

		AmazonProduct product2 = new AmazonProduct();
		product2.setAmount(13.0);
		product2.setArrangementId("12");
		product2.setBookingDate("2017-06-29T10:40:20.090Z");
		product2.setCategory("Office");
		product2.setCounterPartyAccountNumber("654");
		product2.setCounterPartyName("Demon Wheeler");
		product2.setCreditDebitIndicator("CRDT");
		product2.setCurrency("USD");
		product2.setCurrencyExchangeRate(4.13);
		product2.setDescription("Take away");
		product2.setExternalArrangementId("12313-asd-b031-dbe62165d206");
		product2.setExternalId("INTERNAL");
		product2.setId(1);
		product2.setInstructedAmount(223.4);
		product2.setInstructedCurrency("USD");
		product2.setProductId("5cdb2224-8926-4b4d-a99f-1c9dfbbb4699");
		product2.setReference("BCA-509608");
		product2.setStatus("BILLED");
		product2.setValueDate("2017-10-17T12:20:30.090Z");
		amazonProducts.add(product2);

	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * orderBy=id direction=ASC from=1 size=1
	 *
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {

		when(amazonProductService.getAmazonProducts()).thenReturn(amazonProducts);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v2/transactions?orderBy=id&direction=ASC&from=1&size=1");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		final String expected = "{\"responseHeader\":{\"status\":\"success\",\"statusCode\":\"0\"},\"responseBody\":{\"amazonProducts\":[{\"id\":1,\"arrangementId\":\"1\",\"externalId\":\"EXTERNAL127\",\"externalArrangementId\":\"09145149-85ac-4eb5-b031-dbe62165d206\",\"productId\":\"5cdb2224-8926-4b4d-a99f-1c9dfbbb4699\",\"reference\":\"BCA-509608\",\"description\":\"in imperdiet et commodo vulputate justo in blandit ultrices\",\"category\":\"Home\",\"bookingDate\":\"2017-05-25T10:40:20.090Z\",\"valueDate\":\"2017-12-17T12:20:30.090Z\",\"amount\":12.0,\"currency\":\"USD\",\"creditDebitIndicator\":\"CRDT\",\"instructedAmount\":223.4,\"instructedCurrency\":\"USD\",\"currencyExchangeRate\":1.33,\"counterPartyName\":\"Brian Wheeler\",\"counterPartyAccountNumber\":\"1234\",\"status\":\"BILLED\"}]}}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	/**
	 * orderBy=amount direction=ASC from=1 size=2
	 *
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {

		when(amazonProductService.getAmazonProducts()).thenReturn(amazonProducts);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v2/transactions?orderBy=amount&direction=DESC&from=1&size=2");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		final String expected = "{\"responseHeader\":{\"status\":\"success\",\"statusCode\":\"0\"},\"responseBody\":{\"amazonProducts\":[{\"id\":1,\"arrangementId\":\"12\",\"externalId\":\"INTERNAL\",\"externalArrangementId\":\"12313-asd-b031-dbe62165d206\",\"productId\":\"5cdb2224-8926-4b4d-a99f-1c9dfbbb4699\",\"reference\":\"BCA-509608\",\"description\":\"Take away\",\"category\":\"Office\",\"bookingDate\":\"2017-06-29T10:40:20.090Z\",\"valueDate\":\"2017-10-17T12:20:30.090Z\",\"amount\":13.0,\"currency\":\"USD\",\"creditDebitIndicator\":\"CRDT\",\"instructedAmount\":223.4,\"instructedCurrency\":\"USD\",\"currencyExchangeRate\":4.13,\"counterPartyName\":\"Demon Wheeler\",\"counterPartyAccountNumber\":\"654\",\"status\":\"BILLED\"},{\"id\":1,\"arrangementId\":\"1\",\"externalId\":\"EXTERNAL127\",\"externalArrangementId\":\"09145149-85ac-4eb5-b031-dbe62165d206\",\"productId\":\"5cdb2224-8926-4b4d-a99f-1c9dfbbb4699\",\"reference\":\"BCA-509608\",\"description\":\"in imperdiet et commodo vulputate justo in blandit ultrices\",\"category\":\"Home\",\"bookingDate\":\"2017-05-25T10:40:20.090Z\",\"valueDate\":\"2017-12-17T12:20:30.090Z\",\"amount\":12.0,\"currency\":\"USD\",\"creditDebitIndicator\":\"CRDT\",\"instructedAmount\":223.4,\"instructedCurrency\":\"USD\",\"currencyExchangeRate\":1.33,\"counterPartyName\":\"Brian Wheeler\",\"counterPartyAccountNumber\":\"1234\",\"status\":\"BILLED\"}]}}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * orderBy=instructedAmount direction=ASC from=0 size=1
	 *
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {

		when(amazonProductService.getAmazonProducts()).thenReturn(amazonProducts);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v2/transactions?orderBy=instructedAmount&direction=DESC&from=0&size=1");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		final String expected = "{\"responseHeader\":{\"status\":\"success\",\"statusCode\":\"0\"},\"responseBody\":{\"amazonProducts\":[{\"id\":1,\"arrangementId\":\"12\",\"externalId\":\"INTERNAL\",\"externalArrangementId\":\"12313-asd-b031-dbe62165d206\",\"productId\":\"5cdb2224-8926-4b4d-a99f-1c9dfbbb4699\",\"reference\":\"BCA-509608\",\"description\":\"Take away\",\"category\":\"Office\",\"bookingDate\":\"2017-06-29T10:40:20.090Z\",\"valueDate\":\"2017-10-17T12:20:30.090Z\",\"amount\":13.0,\"currency\":\"USD\",\"creditDebitIndicator\":\"CRDT\",\"instructedAmount\":223.4,\"instructedCurrency\":\"USD\",\"currencyExchangeRate\":4.13,\"counterPartyName\":\"Demon Wheeler\",\"counterPartyAccountNumber\":\"654\",\"status\":\"BILLED\"}]}}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * amazonProducts = null
	 *
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {

		when(amazonProductService.getAmazonProducts()).thenReturn(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v2/transactions?orderBy=instructedAmount&direction=DESC&from=0&size=1");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		final String expected = "{\"responseHeader\":{\"status\":\"fail\",\"statusCode\":\"1\"},\"responseBody\":null}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
