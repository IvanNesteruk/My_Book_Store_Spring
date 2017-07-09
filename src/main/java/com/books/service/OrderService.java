package com.books.service;

import java.security.Principal;
import java.util.List;

import com.books.entity.Orders;

public interface OrderService {

    List<Orders> findAll();

    Orders findOne(int id);

    void delete(int id);

    Orders update(Orders orders);

    void addIntoBasket(Principal principal, int id);

    void deleteFromBasket(int userId, int bookId);

    void buy(int userId);

    void save(int userId, List<Integer> booksIds);

    void makeSleep();

    void getTotalPrice();
}
