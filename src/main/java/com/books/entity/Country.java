package com.books.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 28.05.2017.
 */
@Entity
@Table(name = "Country")
public class Country extends AbstractEntity{

    /* @Column(unique=true) */
    @Column(name = "Country")
    private String nameOfCountry;

    @OneToMany(mappedBy = "country")
    private Set<Author> authors = new HashSet<Author>();

    public Country() {
    }

    public Country(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nameOfCountry='" + nameOfCountry + '\'' +
                '}';
    }
}

