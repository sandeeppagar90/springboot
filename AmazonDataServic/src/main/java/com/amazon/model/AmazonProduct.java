package com.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmazonProduct {

	@JsonProperty("id")
	private int id;
	@JsonProperty("arrangementId")
	private String arrangementId;
	@JsonProperty("externalId")
	private String externalId;
	@JsonProperty("externalArrangementId")
	private String externalArrangementId;
	@JsonProperty("productId")
	private String productId;
	@JsonProperty("reference")
	private String reference;
	@JsonProperty("description")
	private String description;
	@JsonProperty("category")
	private String category;
	@JsonProperty("bookingDate")
	private String bookingDate;
	@JsonProperty("valueDate")
	private String valueDate;
	@JsonProperty("amount")
	private double amount;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("creditDebitIndicator")
	private String creditDebitIndicator;
	@JsonProperty("instructedAmount")
	private double instructedAmount;
	@JsonProperty("instructedCurrency")
	private String instructedCurrency;
	@JsonProperty("currencyExchangeRate")
	private double currencyExchangeRate;
	@JsonProperty("counterPartyName")
	private String counterPartyName;
	@JsonProperty("counterPartyAccountNumber")
	private String counterPartyAccountNumber;
	@JsonProperty("status")
	private String status;

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("arrangementId")
	public String getArrangementId() {
		return arrangementId;
	}

	@JsonProperty("arrangementId")
	public void setArrangementId(String arrangementId) {
		this.arrangementId = arrangementId;
	}

	@JsonProperty("externalId")
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("externalId")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@JsonProperty("externalArrangementId")
	public String getExternalArrangementId() {
		return externalArrangementId;
	}

	@JsonProperty("externalArrangementId")
	public void setExternalArrangementId(String externalArrangementId) {
		this.externalArrangementId = externalArrangementId;
	}

	@JsonProperty("productId")
	public String getProductId() {
		return productId;
	}

	@JsonProperty("productId")
	public void setProductId(String productId) {
		this.productId = productId;
	}

	@JsonProperty("reference")
	public String getReference() {
		return reference;
	}

	@JsonProperty("reference")
	public void setReference(String reference) {
		this.reference = reference;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("bookingDate")
	public String getBookingDate() {
		return bookingDate;
	}

	@JsonProperty("bookingDate")
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	@JsonProperty("valueDate")
	public String getValueDate() {
		return valueDate;
	}

	@JsonProperty("valueDate")
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	@JsonProperty("amount")
	public double getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("creditDebitIndicator")
	public String getCreditDebitIndicator() {
		return creditDebitIndicator;
	}

	@JsonProperty("creditDebitIndicator")
	public void setCreditDebitIndicator(String creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
	}

	@JsonProperty("instructedAmount")
	public double getInstructedAmount() {
		return instructedAmount;
	}

	@JsonProperty("instructedAmount")
	public void setInstructedAmount(double instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	@JsonProperty("instructedCurrency")
	public String getInstructedCurrency() {
		return instructedCurrency;
	}

	@JsonProperty("instructedCurrency")
	public void setInstructedCurrency(String instructedCurrency) {
		this.instructedCurrency = instructedCurrency;
	}

	@JsonProperty("currencyExchangeRate")
	public double getCurrencyExchangeRate() {
		return currencyExchangeRate;
	}

	@JsonProperty("currencyExchangeRate")
	public void setCurrencyExchangeRate(double d) {
		this.currencyExchangeRate = d;
	}

	@JsonProperty("counterPartyName")
	public String getCounterPartyName() {
		return counterPartyName;
	}

	@JsonProperty("counterPartyName")
	public void setCounterPartyName(String counterPartyName) {
		this.counterPartyName = counterPartyName;
	}

	@JsonProperty("counterPartyAccountNumber")
	public String getCounterPartyAccountNumber() {
		return counterPartyAccountNumber;
	}

	@JsonProperty("counterPartyAccountNumber")
	public void setCounterPartyAccountNumber(String counterPartyAccountNumber) {
		this.counterPartyAccountNumber = counterPartyAccountNumber;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AmazonProduct [id=" + id + ", arrangementId=" + arrangementId + ", externalId=" + externalId
				+ ", externalArrangementId=" + externalArrangementId + ", productId=" + productId + ", reference="
				+ reference + ", description=" + description + ", category=" + category + ", bookingDate=" + bookingDate
				+ ", valueDate=" + valueDate + ", amount=" + amount + ", currency=" + currency
				+ ", creditDebitIndicator=" + creditDebitIndicator + ", instructedAmount=" + instructedAmount
				+ ", instructedCurrency=" + instructedCurrency + ", currencyExchangeRate=" + currencyExchangeRate
				+ ", counterPartyName=" + counterPartyName + ", counterPartyAccountNumber=" + counterPartyAccountNumber
				+ ", status=" + status + "]";
	}

}
