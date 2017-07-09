package com.books.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book")
public class Book extends AbstractEntity {

    private String titleOfBook;
    private int priceOfBook;
    private String nameOfAuthor;
    private String surnameOfAuthor;
    private short yearOfPublishing;
    private String pathImage;
    private int quantity;

    @ManyToOne
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "UserBook", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "UserID"))
    private Set<User> users = new HashSet<User>();

    @ManyToMany
    @JoinTable(name = "OrderBook", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "OrderID"))
    private Set<Orders> orders = new HashSet<Orders>();

    @ManyToMany
    @JoinTable(name = "AuthorBook", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "AuthorID"))
    private Set<Author> authors = new HashSet<Author>();

    public Book() {
    }

    public Book(String titleOfBook, int priceOfBook, String nameOfAuthor, String surnameOfAuthor,
                short yearOfPublishing,
                Genre genre) {
        super();
        this.titleOfBook = titleOfBook;
        this.priceOfBook = priceOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.surnameOfAuthor = surnameOfAuthor;
        this.yearOfPublishing = yearOfPublishing;
        this.genre = genre;
    }

    public Book(String titleOfBook, int priceOfBook, String nameOfAuthor,
                String surnameOfAuthor, short yearOfPublishing,
                String pathImage, Genre genre) {
        this.titleOfBook = titleOfBook;
        this.priceOfBook = priceOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.surnameOfAuthor = surnameOfAuthor;
        this.yearOfPublishing = yearOfPublishing;
        this.pathImage = pathImage;
        this.genre = genre;
    }

    public Book(String titleOfBook, int priceOfBook, String nameOfAuthor, String surnameOfAuthor, short yearOfPublishing, String pathImage, int quantity, Genre genre) {
        this.titleOfBook = titleOfBook;
        this.priceOfBook = priceOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.surnameOfAuthor = surnameOfAuthor;
        this.yearOfPublishing = yearOfPublishing;
        this.pathImage = pathImage;
        this.genre = genre;
    }

    public Book(String titleOfBook, int priceOfBook, String nameOfAuthor, String surnameOfAuthor, short yearOfPublishing, String pathImage, int quantity) {
        this.titleOfBook = titleOfBook;
        this.priceOfBook = priceOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.surnameOfAuthor = surnameOfAuthor;
        this.yearOfPublishing = yearOfPublishing;
        this.pathImage = pathImage;
        this.quantity = quantity;
    }

    public int getPriceOfBook() {
        return priceOfBook;
    }

    public void setPriceOfBook(int priceOfBook) {
        this.priceOfBook = priceOfBook;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public String getSurnameOfAuthor() {
        return surnameOfAuthor;
    }

    public void setSurnameOfAuthor(String surnameOfAuthor) {
        this.surnameOfAuthor = surnameOfAuthor;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public short getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(short yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book [titleOfBook=" + titleOfBook + ", priceOfBook=" + priceOfBook + ", nameOfAuthor=" + nameOfAuthor
                + ", surnameOfAuthor=" + surnameOfAuthor + ", yearOfPublishing=" + yearOfPublishing + ", genre=" + genre
                + "]";
    }

}