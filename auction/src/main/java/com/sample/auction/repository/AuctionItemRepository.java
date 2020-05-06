package com.sample.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.auction.entity.AuctionItemEntity;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItemEntity, Long> {

}
