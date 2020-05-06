package com.sample.auction.model;

public class AuctionItem {
	private long auctionItemId;
	private double reservePrice;
	private Item item;

	public long getAuctionItemId() {
		return auctionItemId;
	}

	public void setAuctionItemId(long auctionItemId) {
		this.auctionItemId = auctionItemId;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
