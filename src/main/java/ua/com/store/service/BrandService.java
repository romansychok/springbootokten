package ua.com.store.service;


import ua.com.store.entity.Brand;
import ua.com.store.entity.User;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    void save(Brand brand);
    void delete(Brand brand);
    List<Brand> findAll();

   Brand findOne(int id);



}
