package com.sample.auction.model;

public class Bid {
	private long auctionItemId;
	private double maxAutoBidAmount;
	private String bidderName;

	public long getAuctionItemId() {
		return auctionItemId;
	}

	public void setAuctionItemId(long auctionItemId) {
		this.auctionItemId = auctionItemId;
	}

	public double getMaxAutoBidAmount() {
		return maxAutoBidAmount;
	}

	public void setMaxAutoBidAmount(double maxAutoBidAmount) {
		this.maxAutoBidAmount = maxAutoBidAmount;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

}
