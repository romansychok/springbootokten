package ua.com.store.service;

import ua.com.store.entity.Orders;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void save(Orders orders);

    void delete(Orders orders);

    List<Orders> findAll();

    Orders findOne(int id);

    void addIntoBasket(Principal principal, int id);

    void deleteFromBasket(int userId, int bookId);

    void buy(int userId);

    void makeSleep();

    void getTotalPrice();


}
