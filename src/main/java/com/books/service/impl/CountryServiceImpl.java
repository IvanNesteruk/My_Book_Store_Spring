package com.books.service.impl;

import com.books.dao.AuthorDao;
import com.books.dao.CountryDao;
import com.books.entity.Author;
import com.books.entity.Country;
import com.books.service.CountryService;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 28.05.2017.
 */

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDao countryDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    @Qualifier("countryValidator")
    Validator validator;


    @Override
    public void save(Country country) throws Exception {
        country.setNameOfCountry(country.getNameOfCountry().toUpperCase());
        validator.validate(country);
        countryDao.save(country);
    }

    @Override
    public List findAll() {
        return countryDao.findAll();
    }

    @Override
    public Country findOne(int id) {
        return countryDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        Country country = countryDao.findCountryWithAuthors(id);
        for (Author author : country.getAuthors()) {
            author.setCountry(null);
            authorDao.saveAndFlush(author);
        }

        countryDao.delete(id);
    }

    @Override
    public void update(Country country) {
        countryDao.save(country);
    }

    @Override
    public Country findCountryWithAuthors(int id) {
        return countryDao.findCountryWithAuthors(id);
    }
}
