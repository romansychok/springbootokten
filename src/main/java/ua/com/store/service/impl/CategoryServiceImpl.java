package ua.com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.CategoryDAO;
import ua.com.store.dao.ProductDAO;
import ua.com.store.entity.Category;
import ua.com.store.entity.Product;
import ua.com.store.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO dao;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void save(Category category) {
        dao.save(category);
    }

    @Override
    public void delete(int id) {
        Category category = dao.findCategoryWithProduct(id);
        for (Product p : category.getProducts()){
            p.setCategory(null);
            productDAO.saveAndFlush(p);
        }
         dao.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findOne(int id) {
        return dao.findById(id).orElse(null);
    }


}
