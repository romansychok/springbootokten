package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.store.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
