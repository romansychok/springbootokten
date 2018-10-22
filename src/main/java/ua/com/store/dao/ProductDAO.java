package ua.com.store.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.store.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("from Product p where p.id=:id")
    Product findOne(@Param("id") int id);


}
