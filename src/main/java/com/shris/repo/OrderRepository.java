package com.shris.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.shris.domain.Order;
import com.shris.service.Utils;

@Repository
public class OrderRepository {
	
	@Autowired
	private Utils utilsService;
	

	@Cacheable(value = "test", key = "#id")
	public Optional<Order> getOrderById(String id) throws InterruptedException {
		//Thread.sleep(5000);
	//	System.out.println("Simulating a read from the main data store.");
		return Optional.of(utilsService.getOrderData( 20, 100));
	}

	@CachePut(value = "test", key = "#Order.orderId")
	public Order addOrder(Order Order) {
	//	System.out.println("Simulating addition of " + Order + " to the main data store.");
		return Order;
	}

	@CacheEvict(value = "test", key = "#id")
	public void removeOrderById(String id) {
	//	System.out.println("Simulating removal of " + id + " from the main data store.");
	}

	@Cacheable(value = "test", condition = "#Order.ticker =='MSFT' ")
	public Optional<Order> readOrderByTicker(String ticker) {
		// TODO Auto-generated method stub
		return null;
	}
}
