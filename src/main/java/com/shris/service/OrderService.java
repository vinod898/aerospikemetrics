package com.shris.service;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shris.config.AppConfig;
import com.shris.domain.Order;
import com.shris.domain.RequestObj;
import com.shris.repo.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

	@Autowired
	private Utils utilsService;

	OrderRepository orderRepository;

	public Optional<Order> readOrderById(String id) {
		try {
			long startTime, endTime;
			startTime = System.nanoTime();
			Optional<Order> order = orderRepository.getOrderById(id);
			endTime = System.nanoTime();
			log.info("reading time " + (endTime - startTime)+" ns");
			return order;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Order addOrder(Order order) {
		return orderRepository.addOrder(order);
	}

	public void removeOrderById(String id) {
		orderRepository.removeOrderById(id);
	}

	public String generateOrders(RequestObj requestObj) throws InterruptedException {
		return produce(requestObj);
	}

	public String produce(RequestObj requestObj) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(AppConfig.noOfProcesses);
		for (int processLen = 0; processLen < AppConfig.noOfProcesses; processLen++) {
			executorService.submit(() -> {
				producePerThread(requestObj);
			});
		}

		return "success";
	}

	private void producePerThread(RequestObj requestObj) {
		double min_price = requestObj.getMinValue();
		double max_price = requestObj.getMaxValue();
		long totalRecords = requestObj.getNumberOfOrders();

		long sum = 0, startTime, endTime, num = totalRecords / AppConfig.noOfProcesses;
		for (int i = 0; i < num; i++) {
			Order order = utilsService.getOrderData(min_price, max_price);
			startTime = System.currentTimeMillis();
			try {
				addOrder(order);
			} catch (Exception e) {
				e.printStackTrace();
				totalRecords = i;
			}
			endTime = System.currentTimeMillis();
			sum = sum + (endTime - startTime);
		}
		log.info(Thread.currentThread().getName() + " :::" + num + " orders produced in " + sum + "  milli-sec ");
	}

	public Optional<Order> readOrderByTicker(String ticker) {

		return orderRepository.readOrderByTicker(ticker);
	}

}
