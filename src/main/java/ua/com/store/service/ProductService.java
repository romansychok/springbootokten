package ua.com.store.service;

import ua.com.store.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void save(Product product);
    void delete(Product product);
    List<Product> findAll();
    Optional<Product> findOne(int id);


}
