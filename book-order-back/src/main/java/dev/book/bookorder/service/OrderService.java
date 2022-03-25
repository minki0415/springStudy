package dev.book.bookorder.service;

import dev.book.bookorder.model.dto.OrderDTO;

public interface OrderService {
    void insertOrder(OrderDTO orderDTO);
}
