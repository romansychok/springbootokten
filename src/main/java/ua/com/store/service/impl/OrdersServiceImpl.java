package ua.com.store.service.impl;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.OrdersDAO;
import ua.com.store.dao.ProductDAO;
import ua.com.store.dao.UserDAO;
import ua.com.store.entity.Orders;
import ua.com.store.entity.Product;
import ua.com.store.entity.User;
import ua.com.store.service.OrdersService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO dao;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;



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
        return dao.findById(id).orElse(null);
    }


    @Override
    public void addIntoBasket(Principal principal, int id) {
        User user = userDAO.findUserWithProduct(Integer.parseInt(principal.getName()));
        Product product = productDAO.findOne(id);
        user.getProducts().add(product);
        userDAO.save(user);
    }

    @Override
    public void deleteFromBasket(int userId, int bookId) {
        User user = userDAO.findUserWithProduct(userId);
        Product product = productDAO.productsWithUsers(bookId);
        user.getProducts().remove(product);
        userDAO.save(user);

    }

    @Override
    public void buy(int userId) {
        Orders orders = new Orders(LocalDateTime.now());
        dao.saveAndFlush(orders);
        User user = userDAO.findUserWithProduct(userId);
        orders.setUser(user);
        for (Product product : user.getProducts()) {
            orders.getProducts().add(product);

            dao.save(orders);
        }
        user.getProducts().clear();
        userDAO.save(user);

    }

    @Override
    public void makeSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getTotalPrice() {
        int price = 0;

        List<Orders> orders = dao.findAll();
        for (Orders order : orders) {
            Hibernate.initialize(order.getProducts());

            for (Product product : order.getProducts()) {
                price += product.getPrice() *  product.getQuantity();
                order.setTotalPrice(price);
            }

        }



    }


}
