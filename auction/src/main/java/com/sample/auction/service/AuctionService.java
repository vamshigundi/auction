package com.sample.auction.service;

import java.util.List;

import com.sample.auction.model.AuctionItem;
import com.sample.auction.model.Bid;

public interface AuctionService {
	
	public String saveAuction(AuctionItem actionItem);
	
	public List<AuctionItem> getAllAuctionItems();
	
	public AuctionItem getAcionItemById(long auctionItemId);

	public void submitBids(Bid bid);
}
