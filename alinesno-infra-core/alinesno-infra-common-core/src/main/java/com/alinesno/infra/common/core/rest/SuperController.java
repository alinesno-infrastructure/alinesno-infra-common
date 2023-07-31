package com.alinesno.infra.common.core.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public abstract class SuperController {

	private static final Logger log = LoggerFactory.getLogger(SuperController.class);

	protected <T> ResponseEntity<T> ok(T body) {
		return ResponseEntity.ok(body);
	}

}
