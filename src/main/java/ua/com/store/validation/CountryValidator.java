package ua.com.store.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.store.dao.CountryDAO;
import ua.com.store.entity.Country;

@Component
public class CountryValidator implements Validator {

    @Autowired
    private CountryDAO dao;


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Country.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Country country = (Country) target;
        if (country.getCountryName().isEmpty()){
            errors.rejectValue("countryName","","Field is empty");
        }
        else if (dao.findByCountryName(country.getCountryName()) != null){
            errors.rejectValue("countryName","","This country already exist");
        }
    }
}
