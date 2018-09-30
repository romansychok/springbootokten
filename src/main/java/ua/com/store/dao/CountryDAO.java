package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.store.entity.Country;

public interface CountryDAO extends JpaRepository<Country, Integer> {

}
