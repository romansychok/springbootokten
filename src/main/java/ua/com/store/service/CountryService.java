package ua.com.store.service;

import ua.com.store.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    void save(Country country);
    void delete(int id);
    List<Country> findAll();
    Country findByCountryName(String name);
    Country findOne(int id);


}
