package com.sample.auction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value = BidNotMetException.class)
	public ResponseEntity<Object> exception(BidNotMetException exception) {
		return new ResponseEntity<>(exception.getDescription(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ItemNotAvailableException.class)
	public ResponseEntity<Object> itemNotAvailableExceltion(ItemNotAvailableException exception) {
		return new ResponseEntity<>(exception.getDescription(), HttpStatus.NOT_FOUND);
	}
}