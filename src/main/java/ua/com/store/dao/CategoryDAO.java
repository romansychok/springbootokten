package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.store.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

    @Query("from Category c where c.categoryOfProduct=:name")
    Category findByCategoryName(@Param("name") String name);

    @Query("select c from Category c left join c.products where c.id=:id")
    Category findCategoryWithProduct(@Param("id") int id);


}
