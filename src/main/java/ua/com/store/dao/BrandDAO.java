package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.store.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand,Integer>{

}
