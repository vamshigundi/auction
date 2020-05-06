package com.sample.auction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bid")
public class BidEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long auctionItemId;
	private double maxAutoBidAmount;
	private String bidderName;
	private boolean isValidBid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public boolean isValidBid() {
		return isValidBid;
	}

	public void setValidBid(boolean isValidBid) {
		this.isValidBid = isValidBid;
	}

}
