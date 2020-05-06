package com.sample.auction.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.auction.entity.AuctionItemEntity;
import com.sample.auction.entity.BidEntity;
import com.sample.auction.entity.ItemEntity;
import com.sample.auction.exception.BidNotMetException;
import com.sample.auction.exception.ItemNotAvailableException;
import com.sample.auction.model.AuctionItem;
import com.sample.auction.model.Bid;
import com.sample.auction.model.Item;
import com.sample.auction.repository.AuctionItemRepository;
import com.sample.auction.repository.BidRepository;
import com.sample.auction.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private AuctionItemRepository repository;

	@Autowired
	private BidRepository bidRepository;

	@Override
	public String saveAuction(AuctionItem actionItem) {

		AuctionItemEntity auctionItemEntity = new AuctionItemEntity();
		auctionItemEntity.setAuctionItemId(auctionItemEntity.getAuctionItemId());
		auctionItemEntity.setReservePrice(actionItem.getReservePrice());

		ItemEntity item = new ItemEntity();
		item.setItemId(actionItem.getItem().getItemId());
		item.setDescription(actionItem.getItem().getDescription());
		auctionItemEntity.setItem(item);

		AuctionItemEntity response = repository.save(auctionItemEntity);

		return response.getAuctionItemId() + "";
	}

	@Override
	public List<AuctionItem> getAllAuctionItems() {
		List<AuctionItemEntity> auctionItemList = repository.findAll();
		List<AuctionItem> itemsList = new ArrayList<>();
		for (AuctionItemEntity auctionItem : auctionItemList) {
			itemsList.add(convertToActionItem(auctionItem));
		}
		return itemsList;

	}

	@Override
	public AuctionItem getAcionItemById(long auctionItemId) {
		Optional<AuctionItemEntity> item = repository.findById(auctionItemId);

		if (item.isPresent()) {
			return convertToActionItem(item.get());
		}

		return null;
	}

	private AuctionItem convertToActionItem(AuctionItemEntity entity) {
		AuctionItem auctionItem = new AuctionItem();
		auctionItem.setAuctionItemId(entity.getAuctionItemId());
		auctionItem.setReservePrice(entity.getReservePrice());
		Item item = new Item();
		item.setDescription(entity.getItem().getDescription());
		item.setItemId(entity.getItem().getItemId());
		auctionItem.setItem(item);
		return auctionItem;
	}

	@Override
	public void submitBids(Bid bid) {
		AuctionItem item = getAcionItemById(bid.getAuctionItemId());
		if (null != item) {
			if (item.getReservePrice() < bid.getMaxAutoBidAmount()) {
				saveBid(bid, false);
				throw new BidNotMetException("Current Max Audo Bid amount does't met the Reverse Prince");
			} else if (item.getReservePrice() >= bid.getMaxAutoBidAmount()) {
				saveBid(bid, true);
			}
		}else {
			throw new ItemNotAvailableException("Item Not Available");
		}
	}

	private void saveBid(Bid bid, boolean valid) {
		BidEntity entity = new BidEntity();
		entity.setAuctionItemId(bid.getAuctionItemId());
		entity.setBidderName(bid.getBidderName());
		entity.setMaxAutoBidAmount(bid.getMaxAutoBidAmount());
		entity.setValidBid(valid);
		bidRepository.save(entity);

	}

}
