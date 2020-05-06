package com.sample.auction.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auction_item")
public class AuctionItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long auctionItemId;
	private double reservePrice;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "action_item_id")
	private ItemEntity item;

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

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

}
