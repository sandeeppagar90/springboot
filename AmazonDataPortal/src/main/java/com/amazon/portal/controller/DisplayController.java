package com.amazon.portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazon.model.AmazonProduct;
import com.portal.rest.service.ProductDetailService;
import com.portal.rest.service.impl.ProductDetailServiceImpl;

/**
 * This is web application display controller implements an functionality that
 * simply call the web service and display data in tabular form.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-06
 */
@Controller
public class DisplayController {

	private final Logger logger = LoggerFactory.getLogger(DisplayController.class);
	private final String SERVICE_NOTE_AVAILABLE = "service temporarily unavailable please wait for a while";

	private final String VIEW = "product";
	private ProductDetailService productDetailService;

	/**
	 * This is render method which display from for filter criteria.
	 * 
	 * @return
	 */
	@RequestMapping("/amazon/search.sp")
	public String getSearchForm() {
		return VIEW;
	}

	/**
	 * This method calls the WS and retun data to view to display.
	 * 
	 * @param orderBy
	 * @param direction
	 * @param from
	 * @param size
	 * @param model
	 * @return
	 */
	@PostMapping("/amazon/displayData.sp")
	public String getProductDetail(@RequestParam("orderby") String orderBy, @RequestParam("direction") String direction,
			@RequestParam("from") String from, @RequestParam("size") String size, Model model) {

		final String method = "getProductDetail";
		logger.info(method + " :: Enter");

		try {
			productDetailService = new ProductDetailServiceImpl();
			// Get product details from service
			List<AmazonProduct> amazonProducts = productDetailService.getAmazonProducts(orderBy, direction, from, size);

			model.addAttribute("amazonProducts", amazonProducts);

		} catch (Exception e) {
			logger.error(method + " :: Exception: " + e);
			model.addAttribute("serviceNotAvailable", SERVICE_NOTE_AVAILABLE);
		}
		logger.info(method + " :: Exit");

		return VIEW;
	}

}
