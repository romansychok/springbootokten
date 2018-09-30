package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.store.entity.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
}
