package ua.com.store.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.store.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
