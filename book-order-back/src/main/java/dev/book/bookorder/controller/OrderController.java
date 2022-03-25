package dev.book.bookorder.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.book.bookorder.model.dto.OrderDTO;
import dev.book.bookorder.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping() // POST : ~/api/v1/orders
    public void insertOrder(@RequestBody OrderDTO orderDTO) {
        // System.out.println(orderDTO);
        // service -> repository -> DB
        orderService.insertOrder(orderDTO);
    }
}
