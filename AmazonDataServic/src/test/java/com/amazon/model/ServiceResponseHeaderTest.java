package com.amazon.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceResponseHeaderTest {

	ServiceResponseHeader responseHeader;
	@Before
	public void setUp() throws Exception {
		responseHeader = new ServiceResponseHeader();
		responseHeader.setStatus("success");
		responseHeader.setStatusCode("1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		final String status = responseHeader.getStatus();
		assertEquals("success", status);
		
		final String code = responseHeader.getStatusCode();
		assertEquals("1", code);
	}

}
