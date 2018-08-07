package com.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is entry point to Amazon product WS application. This bootstraps the
 * execution.
 * 
 * @author Sandeep Pagar
 * @version 1.0
 * @since 2018-08-05
 */
@SpringBootApplication
public class SpringBootServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootServiceApplication.class, args);
	}
}
