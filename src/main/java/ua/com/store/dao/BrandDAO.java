package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.store.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand,Integer>{

    @Query("from Brand b where b.id=:id")
    Brand findOne(@Param("id") int id );

}
