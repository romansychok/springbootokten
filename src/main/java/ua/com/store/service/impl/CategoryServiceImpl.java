package ua.com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.CategoryDAO;
import ua.com.store.entity.Category;
import ua.com.store.service.CategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO dao;

    @Override
    public void save(Category category) {
        dao.save(category);
    }

    @Override
    public void delete(Category category) {
        dao.delete(category);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findOne(int id) {
        return null;
    }
}
