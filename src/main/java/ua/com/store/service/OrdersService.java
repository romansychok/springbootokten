package ua.com.store.service;

import ua.com.store.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void save(Orders orders);
    void delete(Orders orders);
    List<Orders> findAll();
    Optional<Orders> findOne(int id);



}
