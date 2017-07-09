package com.books.DTO;

/**
 * Created by User on 27.06.2017.
 */
public class BookDTO {
    private String titleOfBook;
    private int priceOfBook;

    public BookDTO() {
    }

    public BookDTO(String titleOfBook, int priceOfBook) {
        this.titleOfBook = titleOfBook;
        this.priceOfBook = priceOfBook;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public int getPriceOfBook() {
        return priceOfBook;
    }

    public void setPriceOfBook(int priceOfBook) {
        this.priceOfBook = priceOfBook;
    }
}
