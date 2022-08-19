package com.eazybytes.loans.context;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RequestContext {

	public static final String CORRELATION_ID = "eazybank-correlation-id";

	private String correlationId = new String();

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public static String getCorrelationId() {
		return CORRELATION_ID;
	}

}