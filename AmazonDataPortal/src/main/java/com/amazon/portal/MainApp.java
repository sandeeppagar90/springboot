package com.amazon.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is entry point to Web application, which print the details from WS in
 * tabular form. This bootstraps the execution.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-06
 */
@SpringBootApplication
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}
