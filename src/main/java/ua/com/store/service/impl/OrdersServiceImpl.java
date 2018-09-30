package ua.com.store.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.OrdersDAO;
import ua.com.store.entity.Orders;
import ua.com.store.service.OrdersService;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO dao;

    @Override
    public void save(Orders orders) {
        dao.save(orders);
    }

    @Override
    public void delete(Orders orders) {
        dao.delete(orders);
    }

    @Override
    public List<Orders> findAll() {
        return dao.findAll();
    }

    @Override
    public Orders findOne(int id) {
        return null;
    }
}
