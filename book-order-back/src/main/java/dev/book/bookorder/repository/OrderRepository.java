package dev.book.bookorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.book.bookorder.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
