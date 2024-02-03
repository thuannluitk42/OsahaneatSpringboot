package com.thuannluit.osahaneat.repository;

import com.thuannluit.osahaneat.entity.OrderItem;
import com.thuannluit.osahaneat.entity.keys.KeyOrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrdersItem> {
}
