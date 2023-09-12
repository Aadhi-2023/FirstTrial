package com.yectra.roos.order.model;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container
public class Order extends Persistence {

	@Override
	public void setType(String type) {
		this.type = "Order";
	}

}