package com.amazon.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AmazonProductTest {

	private AmazonProduct product;

	@Before
	public void setUp() throws Exception {

		product = new AmazonProduct();

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {

		final double amount = product.getAmount();
		assertEquals(12.0, amount,00.0);

		final String arrangementyId = product.getArrangementId();
		assertEquals("1", arrangementyId);

		final String bookingDte = product.getBookingDate();
		assertEquals("2017-05-25T10:40:20.090Z", bookingDte);

		final String catagory = product.getCategory();
		assertEquals("Home", catagory);

		final String counterPartyAcc = product.getCounterPartyAccountNumber();
		assertEquals("1234", counterPartyAcc);

		final String counterPartyName = product.getCounterPartyName();
		assertEquals("Brian Wheeler", counterPartyName);

		final String creaditDebitInd = product.getCreditDebitIndicator();
		assertEquals("CRDT", creaditDebitInd);

		final String currency = product.getCurrency();
		assertEquals("USD", currency);

		final double currencyExchangeRate = product.getCurrencyExchangeRate();
		assertEquals(1.33, currencyExchangeRate, 00.0);

		final String description = product.getDescription();
		assertEquals("in imperdiet et commodo vulputate justo in blandit ultrices", description);

		final String externalArrang = product.getExternalArrangementId();
		assertEquals("09145149-85ac-4eb5-b031-dbe62165d206", externalArrang);

		final String externalId = product.getExternalId();
		assertEquals("EXTERNAL127", externalId);

		final int id = product.getId();
		assertEquals(1, id);

		final double instructedAmt = product.getInstructedAmount();
		assertEquals(223.4, instructedAmt, 00.0);

		final String instructedCurrency = product.getInstructedCurrency();
		assertEquals("USD", instructedCurrency);

		final String prodId = product.getProductId();
		assertEquals("5cdb2224-8926-4b4d-a99f-1c9dfbbb4699", prodId);

		final String reference = product.getReference();
		assertEquals("BCA-509608", reference);

		final String status = product.getStatus();
		assertEquals("BILLED", status);

		final String valueDate = product.getValueDate();
		assertEquals("2017-12-17T12:20:30.090Z", valueDate);

	}

}
