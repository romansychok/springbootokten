package ua.com.store.service;

import ua.com.store.entity.Country;

import java.util.List;

public interface CountryService {

    void save(Country country);
    void delete(Country country);
    List<Country> findAll();
    Country findOne(int id);
    Country findByCountryName(String name);


}
