package com.books.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Magazine")
public class Magazine extends AbstractEntity{

    private String titleOfMagazine;
    private String priceOfMagazine;

    @ManyToMany
    @JoinTable(name = "UserMagazine", joinColumns = @JoinColumn(name = "MagazineID"), inverseJoinColumns = @JoinColumn(name = "UserID"))
    private Set<User> users = new HashSet<User>();

    public Magazine() {
    }

    public Magazine(String titleOfMagazine, String priceOfMagazine) {
        this.titleOfMagazine = titleOfMagazine;
        this.priceOfMagazine = priceOfMagazine;
    }

    public Magazine(String titleOfMagazine) {
        this.titleOfMagazine = titleOfMagazine;
    }

    public String getTitleOfMagazine() {
        return titleOfMagazine;
    }

    public void setTitleOfMagazine(String titleOfMagazine) {
        this.titleOfMagazine = titleOfMagazine;
    }

    public String getPriceOfMagazine() {
        return priceOfMagazine;
    }

    public void setPriceOfMagazine(String priceOfMagazine) {
        this.priceOfMagazine = priceOfMagazine;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "titleOfMagazine='" + titleOfMagazine + '\'' +
                ", priceOfMagazine='" + priceOfMagazine + '\'' +
                '}';
    }
}
