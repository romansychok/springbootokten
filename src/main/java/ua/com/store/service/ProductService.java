package ua.com.store.service;

import ua.com.store.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);
    void delete(Product product);
    List<Product> findAll();
    Product findOne(int id);


}
