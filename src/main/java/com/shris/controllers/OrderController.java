package com.shris.controllers;


import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shris.domain.Order;
import com.shris.domain.RequestObj;
import com.shris.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderController {

    OrderService orderService;

    @GetMapping("/orders/{id}")
    public Optional<Order> readOrderById(@PathVariable("id") String id) {
        return orderService.readOrderById(id);
    }
    
    @GetMapping("/ordersbyticker/{ticker}")
    public Optional<Order> readOrderByTicker(@PathVariable("ticker") String ticker) {
        return orderService.readOrderByTicker(ticker);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
    
    @PostMapping("/generate")
    public String  generateOrders(@RequestBody RequestObj requestOj) throws InterruptedException {
        return orderService.generateOrders(requestOj);       
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrderById(@PathVariable("id") String id) {
        orderService.removeOrderById(id);
    }
}
