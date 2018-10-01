package ua.com.store.service;


import ua.com.store.entity.Brand;

import java.util.List;

public interface BrandService {

    void save(Brand brand);
    void delete(Brand brand);
    List<Brand> findAll();

    Brand findOne(int id);



}
