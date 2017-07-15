package com.books.service;

import com.books.entity.Country;
import com.books.entity.User;

import java.util.List;

/**
 * Created by User on 28.05.2017.
 */
public interface CountryService {

    void save(Country country) throws Exception;

    List<Country> findAll();

    Country findOne(int id);

    void delete(int id);

    void update(Country country);

    Country findCountryWithAuthors(int id);
}
