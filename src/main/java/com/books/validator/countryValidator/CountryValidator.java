package com.books.validator.countryValidator;

import com.books.dao.CountryDao;
import com.books.entity.Country;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by User on 30.05.2017.
 */

@Component
public class CountryValidator implements Validator {

    @Autowired
    CountryDao countryDao;
    @Override
    public void validate(Object o) throws Exception {
        Country country = (Country) o;

        if(country.getNameOfCountry().isEmpty()){
            throw  new CountryException(CountryValidationMessages.EMPTY_COUNTRYNAME_FIELD);
        } else if (countryDao.findByNameOfCountry(country.getNameOfCountry()) != null){
            throw  new CountryException(CountryValidationMessages.COUNTRYNAME_ALREADY_EXISTS);
        }
    }
}
