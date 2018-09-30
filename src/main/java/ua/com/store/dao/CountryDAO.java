package ua.com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.store.entity.Country;

public interface CountryDAO extends JpaRepository<Country, Integer> {

    @Query("from Country c where c.countryName=:name")
    Country findByCountryName(@Param("name") String name);

}
