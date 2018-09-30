package ua.com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.CountryDAO;
import ua.com.store.entity.Country;
import ua.com.store.service.CountryService;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

   @Autowired
   private CountryDAO dao;

    @Override
    public void save(Country country) {
        dao.save(country);
    }

    @Override
    public void delete(Country country) {
        dao.delete(country);
    }

    @Override
    public List<Country> findAll() {
        return dao.findAll();
    }

    @Override
    public Country findOne(int id) {
        return null;
    }

    @Override
    public Country findByCountryName(String name) {
        return dao.findByCountryName(name);
    }
}
