package ua.com.store.service;

import ua.com.store.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);
    void delete(Category category);
    List<Category> findAll();
    Category findOne(int id);

}
