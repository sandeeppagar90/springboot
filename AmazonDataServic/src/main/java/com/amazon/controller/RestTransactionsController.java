package com.amazon.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.model.AmazonProduct;
import com.amazon.model.AmazonProductResponse;
import com.amazon.model.ServiceResponseBody;
import com.amazon.model.ServiceResponseHeader;
import com.amazon.rest.service.AmazonProductService;

/**
 * This is rest transaction controller implements an functionality that simply
 * accept the service request with different parameter, call the amazon data
 * service and returns this filter data based on the request parameter.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-05
 */
@RestController
public class RestTransactionsController {

	private final Logger logger = LoggerFactory.getLogger(RestTransactionsController.class);
	
	private final String SUCCESS = "success";
	private final String SUCCESS_STATUS_CODE = "0";
	
	private final String FAIL = "fail";
	private final String FAIL_STATUS_CODE = "1";
	
	private final String DESC_ORDER = "DESC";
	private final String ORDER_BY_AMOUNT= "amount";
	private final String ORDER_BY_INSTRUCTEDAMOUNT = "instructedAmount";
	private final String ORDER_BY_ID = "id";
		
	@Autowired
	private AmazonProductService amazonProductService;

	/**
	 * This method filter the data from amazon product service based in the below
	 * request parameter. 
	 * 1) Order by amount, id or instructedAmount.
	 * 2) In ascending or descending direction 
	 * 3) paging
	 * 
	 * @param orderBy
	 * @param direction
	 * @param from
	 * @param size
	 * @return
	 */
	@RequestMapping("/v2/transactions")
	public AmazonProductResponse getProductDetails(@RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction, @RequestParam("from") String from,
			@RequestParam("size") String size) {

		final String method = "getProductDetails";

		logger.info(method + " :: Enter");

		logger.debug(
				method + " :: orderBy: " + orderBy + " direction: " + direction + "from: " + from + "size: " + size);

		// Get product details from service
		List<AmazonProduct> amazonProducts = amazonProductService.getAmazonProducts();

		AmazonProductResponse response = new AmazonProductResponse();
		ServiceResponseBody responseBody = new ServiceResponseBody();
		ServiceResponseHeader responseHeader = new ServiceResponseHeader();
		
		if(null != amazonProducts) {
			
			// Get sorted record based orderBy and direction value
			List<AmazonProduct> sortedList = getSortedRecords(amazonProducts, orderBy, direction);

			// Return sub list based on from and size value
			if( !(StringUtils.isEmpty(from)) && !(StringUtils.isEmpty(from)) ) {
				final int intFrom = Integer.parseInt(from);
				final int intSize = Integer.parseInt(size);
				List<AmazonProduct> subList = getPaging(sortedList, intFrom, intSize);
				responseBody.setAmazonProducts(subList);
			}else {
				responseBody.setAmazonProducts(sortedList);
			}

			// subList.forEach((developer) -> logger.debug(developer));
			
			responseHeader.setStatus(SUCCESS);
			responseHeader.setStatusCode(SUCCESS_STATUS_CODE);
			
						
			response.setResponseHeader(responseHeader);
			response.setResponseBody(responseBody);
		}else {
			
			responseHeader.setStatus(FAIL);
			responseHeader.setStatusCode(FAIL_STATUS_CODE);
			
			responseBody.setAmazonProducts(null);
			
			response.setResponseHeader(responseHeader);
			response.setResponseHeader(responseHeader);
		}

		logger.info(method + " :: Exit");

		return response;
	}

	/**
	 * This method returns the sub list, which start index is 'from' variable value
	 * and number of elements are equals to 'size' variable value.
	 * 
	 * @param amazonProducts
	 *            - list of all records from amazon product service.
	 * @param from
	 *            - List start index for sub list creation
	 * @param size
	 *            - Number of elements/records in sub list
	 * @return subList
	 */
	private List<AmazonProduct> getPaging(List<AmazonProduct> amazonProducts, int from, int size) {

		final String method = "getPaging";
		logger.info(method + " :: Enter");

		// If user enter from value as 0 the round it to 1.
		if (from == 0) {
			from = 1;
		}
		// To start from actual index of list. eg. from = 1 then for similar list index
		// should be 0 to return correct records
		from = from - 1;

		List<AmazonProduct> subList = amazonProducts.subList(from, from + size);
		logger.debug(method + " ::Sub list size:" + subList.size());

		logger.info(method + " :: Exit");
		return subList;
	}

	/**
	 * This method sort the list by amount, id or instructedAmount value, 
	 * in ascending or descending order.
	 * 
	 * @param amazonProducts
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	private List<AmazonProduct> getSortedRecords(List<AmazonProduct> amazonProducts, String orderBy, String direction) {

		final String method = "getSortedRecords";
		logger.info(method + " :: Enter");

		logger.debug(method + " :: orderBy: " + orderBy);

		switch (orderBy) {
		case ORDER_BY_ID:
			Collections.sort(amazonProducts, (AmazonProduct p1, AmazonProduct p2) -> p1.getId() - p2.getId());
			break;

		case ORDER_BY_AMOUNT:

			/*
			 * Collections.sort(amazonProducts, new Comparator<AmazonProduct>() {
			 * 
			 * @Override public int compare(AmazonProduct p1, AmazonProduct p2) { return
			 * Double.compare(p1.getAmount(), p2.getAmount()); } });
			 */

			Collections.sort(amazonProducts,
					(AmazonProduct p1, AmazonProduct p2) -> Double.compare(p1.getAmount(), p2.getAmount()));

			break;

		case ORDER_BY_INSTRUCTEDAMOUNT:

			Collections.sort(amazonProducts, (AmazonProduct p1, AmazonProduct p2) -> Double
					.compare(p1.getInstructedAmount(), p2.getInstructedAmount()));
			break;

		default:
			// No action
			break;
		}

		// Reverse list in case of direction is DESC
		if (direction.equalsIgnoreCase(DESC_ORDER)) {
			Collections.reverse(amazonProducts);
		}

		logger.info(method + " :: Exit");

		return amazonProducts;
	}

	public AmazonProductService getAmazonProductService() {
		return amazonProductService;
	}

	public void setAmazonProductService(AmazonProductService amazonProductService) {
		this.amazonProductService = amazonProductService;
	}
}
