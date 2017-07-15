package com.books.dao;

import com.books.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by User on 28.05.2017.
 */
public interface CountryDao extends JpaRepository<Country, Integer> {

    Country findByNameOfCountry(String name);
    @Query("SELECT c FROM Country c left join fetch c.authors WHERE c.id=:id")
    Country findCountryWithAuthors(@Param("id") int id);
}
