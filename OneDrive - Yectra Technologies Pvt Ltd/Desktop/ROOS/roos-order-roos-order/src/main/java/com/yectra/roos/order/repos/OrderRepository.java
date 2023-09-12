package com.yectra.roos.order.repos;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.yectra.roos.order.model.Order;

@Repository
public interface OrderRepository extends CosmosRepository<Order, String> {
	
}