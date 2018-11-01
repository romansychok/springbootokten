package ua.com.store.service;

import ua.com.store.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void save(Category category);
    void delete(int id);
    List<Category> findAll();
    Category findOne(int id);


}
