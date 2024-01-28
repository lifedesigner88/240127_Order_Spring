package com.encore.oreder.order.repository;

import com.encore.oreder.order.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
