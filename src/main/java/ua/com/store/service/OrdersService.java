package ua.com.store.service;

import ua.com.store.entity.Orders;

import java.util.List;

public interface OrdersService {

    void save(Orders orders);
    void delete(Orders orders);
    List<Orders> findAll();
    Orders findOne(int id);



}
