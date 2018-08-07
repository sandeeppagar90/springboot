package com.amazon.model;

public class AmazonProductResponse {

	private ServiceResponseHeader responseHeader;
	private ServiceResponseBody responseBody;

	public ServiceResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ServiceResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public ServiceResponseBody getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(ServiceResponseBody responseBody) {
		this.responseBody = responseBody;
	}

}
