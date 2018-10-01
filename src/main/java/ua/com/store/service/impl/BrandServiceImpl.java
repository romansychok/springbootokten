package ua.com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.BrandDAO;
import ua.com.store.entity.Brand;
import ua.com.store.service.BrandService;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDAO dao;


    @Override
    public void save(Brand brand) {
        dao.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        dao.delete(brand);
    }

    @Override
    public List<Brand> findAll() {
        return dao.findAll();
    }


    @Override
    public Brand findOne(int id) {
      return null;
    }
}
