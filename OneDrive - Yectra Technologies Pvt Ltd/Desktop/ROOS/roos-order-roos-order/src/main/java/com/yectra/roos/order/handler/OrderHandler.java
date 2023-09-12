package com.yectra.roos.order.handler;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.yectra.roos.order.model.Order;

@Component
public class OrderHandler {

	@Autowired
	private Function<Order, String> createOrder;

	@Autowired
	private Function<String, Order> getOrder;

	@Autowired
	private Function<Order, String> updateOrder;

	@Autowired
	private Function<String, String> deleteOrder;

	@FunctionName("CreatOrder")
	public HttpResponseMessage createOrder(@HttpTrigger(name = "request", methods = {
			HttpMethod.POST }, route = "order", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Order> request,
			ExecutionContext context) {
		final Order order = request.getBody();
		context.getLogger().info(String.format("Create Order : %s ", order));
		return request.createResponseBuilder(HttpStatus.OK).body(createOrder.apply(order))
				.header("Content-Type", "application/json").build();
	}

	@FunctionName("GetOrder")
	public HttpResponseMessage getOrder(@HttpTrigger(name = "request", methods = {
			HttpMethod.GET }, route = "order/{id}", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<String> request,
			ExecutionContext context, @BindingName(value = "id") String id) {
		context.getLogger().info(String.format("Get Order : %s ", id));
		return request.createResponseBuilder(HttpStatus.OK).body(getOrder.apply(id))
				.header("Content-Type", "application/json").build();
	}

	@FunctionName("UpdateOrder")
	public HttpResponseMessage updateOrder(@HttpTrigger(name = "request", methods = {
			HttpMethod.PUT }, route = "order/{id}", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Order> request,
			ExecutionContext context, @BindingName(value = "id") String id) {
		context.getLogger().info(String.format("Update Order : %s ", id));
		Order order = request.getBody();
		order.setId(id);
		return request.createResponseBuilder(HttpStatus.OK).body("Updated Order id : " + updateOrder.apply(order))
				.header("Content-Type", "application/json").build();
	}

	@FunctionName("deleteOrder")
	public HttpResponseMessage deleteOrder(@HttpTrigger(name = "request", methods = {
			HttpMethod.DELETE }, route = "order/{id}", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<String> request,
			ExecutionContext context, @BindingName(value = "id") String id) {
		context.getLogger().info(String.format("Delete Order : %s ", id));
		return request.createResponseBuilder(HttpStatus.OK).body(deleteOrder.apply(id))
				.header("Content-Type", "application/json").build();
	}
}
