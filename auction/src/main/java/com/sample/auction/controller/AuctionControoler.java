package com.sample.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.auction.model.AuctionItem;
import com.sample.auction.model.Bid;
import com.sample.auction.service.AuctionService;

@RestController
public class AuctionControoler {

	@Autowired
	private AuctionService service;

	@PostMapping("/auctionItems")
	public ResponseEntity<String> saveAction(@RequestBody AuctionItem item) {
		String auctionId = service.saveAuction(item);
		return new ResponseEntity<String>(auctionId, HttpStatus.CREATED);
	}

	@GetMapping("/auctionItems")
	public ResponseEntity<List<AuctionItem>> getActionIteams() {
		List<AuctionItem> auctionItemList = service.getAllAuctionItems();

		return new ResponseEntity<List<AuctionItem>>(auctionItemList, HttpStatus.OK);
	}

	@GetMapping("/auctionItems/{id}")
	public ResponseEntity<AuctionItem> getActionIteams(@PathVariable("id") long auctionItemId) {
		AuctionItem item = service.getAcionItemById(auctionItemId);

		return new ResponseEntity<AuctionItem>(item, HttpStatus.OK);

	}

	@PostMapping("/bids")
	public ResponseEntity<Void> bids(@RequestBody Bid bid) {

		service.submitBids(bid);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
