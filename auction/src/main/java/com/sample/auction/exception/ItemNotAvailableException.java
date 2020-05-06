package com.sample.auction.exception;

public class ItemNotAvailableException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String description;

	public ItemNotAvailableException(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
