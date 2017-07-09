package com.books.dao;

import com.books.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 28.05.2017.
 */
public interface CountryDao extends JpaRepository<Country, Integer> {

    Country findByNameOfCountry(String name);
}
