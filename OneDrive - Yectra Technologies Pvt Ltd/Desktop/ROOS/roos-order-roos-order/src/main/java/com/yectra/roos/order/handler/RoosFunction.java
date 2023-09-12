package com.yectra.roos.order.handler;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.yectra.roos.order.model.Order;
import com.yectra.roos.order.repos.OrderRepository;

@Component
public class RoosFunction  {
	
	@Autowired
	private OrderRepository orderRepository;

   @Bean
   public Function<Order, String> createOrder() {
       return payload -> {
    	   Order order = orderRepository.save(payload);
           return order.getId();         
       };
   }

   @Bean
   public Function<String, Order> getOrder() {
       return payload -> {
    	   Optional<Order> order = orderRepository.findById(payload);
           return order.isPresent()?order.get():null;         
       };
   }
   
   @Bean
	public Function<Order, String> updateOrder() {
		return payload -> {
			Order order = orderRepository.save(payload);
			order.setId(order.getId());
			return order.getId();
		};
	}

	@Bean
	public Function<String, String> deleteOrder() {
		return payload -> {
			Optional<Order> order = orderRepository.findById(payload);
			if (order.isPresent()) {
				orderRepository.delete(order.get());
				return "Service deleted successfully.";
			} else {
				return "Service not found.";
			}
		};
	}
   
}
